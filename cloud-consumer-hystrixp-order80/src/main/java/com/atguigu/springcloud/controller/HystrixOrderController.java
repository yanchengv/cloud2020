package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixOrderFeignService;
import com.atguigu.springcloud.service.HystrixOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixOrderController {
    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/order/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = hystrixOrderService.paymentInfo_OK(id);
        System.out.println("************result"+result);
        return result;
    }

    @GetMapping("/order/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        String result =hystrixOrderService.paymentInfo_Timeout(id);
        System.out.println("************result"+result);
        return result;
    }

}
