package com.atguigu.springcloud.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RabbitMqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/mq/send")
    public String send(){
        String s = "hello yan"+ UUID.randomUUID().toString();
        System.out.println(s);
        amqpTemplate.convertAndSend("test1","test1q",s);
        return s;
    }

}
