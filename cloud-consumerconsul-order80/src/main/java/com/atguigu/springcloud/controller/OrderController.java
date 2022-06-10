package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    private static  final  String PAYMENT_URL = "http://consul-cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/consul/get")
    public String getOrder(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul/", String.class);
    }
}
