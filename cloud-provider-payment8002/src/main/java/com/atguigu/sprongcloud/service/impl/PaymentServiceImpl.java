package com.atguigu.sprongcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.sprongcloud.dao.PaymentDao;
import com.atguigu.sprongcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
