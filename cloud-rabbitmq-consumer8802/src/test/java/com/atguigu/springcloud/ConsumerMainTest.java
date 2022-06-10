package com.atguigu.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ConsumerMainTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    void send() {
        String s = "hello yan"+ UUID.randomUUID().toString();
        System.out.println(s);
        amqpTemplate.convertAndSend("test1","test1q",s);
    }



    @Test
    @RabbitListener(queues = "q1")
    public void receiveMessage1(String message) throws Exception{
        System.out.println("test:接收消息q1:" +message);
    }

    @Test
    @RabbitListener(queues = "q2")
    public void receiveMessage2(String message) throws Exception{
        System.out.println("test:接收消息q2:" +message);

    }
}
