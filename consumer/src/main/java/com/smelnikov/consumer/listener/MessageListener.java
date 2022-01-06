package com.smelnikov.consumer.listener;

import com.smelnikov.consumer.service.ProductService;
import com.smelnikov.libs.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class MessageListener {

    @Autowired
    private ProductService productService;

    @KafkaListener(topics = "user", containerFactory = "kafkaListenerContainerFactory")
    public void listener (Product product){
        System.out.println("Recieved message: " + product);
        productService.saveMessage(product);
    }

}