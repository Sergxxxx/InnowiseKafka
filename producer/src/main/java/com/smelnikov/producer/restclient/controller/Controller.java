package com.smelnikov.producer.restclient.controller;

import com.smelnikov.libs.dto.Product;
import com.smelnikov.producer.restclient.service.Producer;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class Controller {

    private final Producer producer;

    @PostMapping(value = "/publish")
    public Product sendMessage(@RequestBody Product product){
        producer.sendMessage(product);
        return product;
    }

//    @Bean
//    public NewTopic adviceTopic(){
//        return new NewTopic("user", 3, (short) 1);
//    }
}
