package com.atguigui.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @GetMapping("/getPay")
    public String getPay() {
        return "获取支付83" + UUID.randomUUID().toString();
    }

    @PostMapping("/createPay")
    public String createPay() {
        return "支付成功83" + UUID.randomUUID().toString();
    }
}
