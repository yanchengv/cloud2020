package com.atguigu.springcloud.service;


import org.springframework.stereotype.Service;

@Service
public class PaymentFallbackService  implements  HystrixOrderFeignService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "============PaymentFallbackService===";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "=========paymentInfo_Timeout===";
    }
}
