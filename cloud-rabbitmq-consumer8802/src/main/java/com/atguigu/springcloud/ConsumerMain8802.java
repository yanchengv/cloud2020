package com.atguigu.springcloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class ConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8802.class,args);
    }
}
