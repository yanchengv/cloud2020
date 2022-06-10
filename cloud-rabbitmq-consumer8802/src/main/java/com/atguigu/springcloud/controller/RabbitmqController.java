package com.atguigu.springcloud.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

    @RabbitListener(queues = "q1")
    public void receiveMessage1(String message) throws Exception{
        System.out.println("接收消息q1:" +message);
    }

    @RabbitListener(queues = "q2")
    public void receiveMessage2(String message) throws Exception{
        System.out.println("接收消息q2:" +message);

    }
}
