package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@DefaultProperties(defaultFallback = "globalTimeoutFallback")

public class HystrixOrderService {

    @Autowired
    private HystrixOrderFeignService hystrixOrderFeignService;


    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = hystrixOrderFeignService.paymentInfo_OK(id);
        return result;
//        return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok,id" + id + "\t" + "O(∩_∩)O哈哈~";

    }

    ;

    //配置命令执行的超时时间
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = hystrixOrderFeignService.paymentInfo_Timeout(id);
//        return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok,id" + id + "\t" + "O(∩_∩)O哈哈~";
        return result;
    }

    public String orderInfo_TimeoutHandler(@PathVariable("id") Integer id) {
        return "线程池" + Thread.currentThread().getName() + "orderInfo_TimeoutHandler,id" + id + "\t" + "O(∩_∩)O哈哈~";

    }

    public String globalTimeoutFallback() {
        return "Global全局异常处理信息111";
    }


}
