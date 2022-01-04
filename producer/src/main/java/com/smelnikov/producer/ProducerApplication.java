package com.smelnikov.producer;

import com.smelnikov.producer.kafka.MessageProducer;
import com.smelnikov.producer.restclient.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ProducerApplication.class, args);
        MessageProducer producer = context.getBean(MessageProducer.class);
        ProductService service = context.getBean(ProductService.class);

        service.getProduct(3).forEach(producer::sendMessage);
    }

}
