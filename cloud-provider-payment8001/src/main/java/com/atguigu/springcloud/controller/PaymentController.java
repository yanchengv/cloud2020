package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {

            return new CommonResult(200, "创建成功,端口号" + serverPort, result);
        } else {
            return new CommonResult(444, "创建失败", null);
        }

    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return CommonResult.success("查询成功，端口号" + serverPort, payment);
        } else {
            return CommonResult.error();
        }

    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> service = discoveryClient.getServices();
        for (String s : service) {
            System.out.println(s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance: instances){
            System.out.println(instance.getServiceId()+instance.getHost()+":"+instance.getPort()+"uri:"+instance.getUri());
        }

        return this.discoveryClient;
    }



}
