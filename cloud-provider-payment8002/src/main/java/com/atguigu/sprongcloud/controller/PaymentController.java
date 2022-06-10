package com.atguigu.sprongcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.sprongcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableEurekaClient
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result > 0 ){

            return new CommonResult(200,"创建成功,端口号"+serverPort,result);
        }else{
            return new CommonResult(444,"创建失败",null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        System.out.println(11);
        Payment payment = paymentService.getPaymentById(id);
        if(payment !=  null ){
            return CommonResult.success("查询成功，端口号："+serverPort,payment);
        }else{
            return CommonResult.error();
        }

    }

}
