package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池" + Thread.currentThread().getName()+"paymentInfo_OK,id" + id+"\t" + "O(∩_∩)O哈哈~";
    }

    //配置命令执行的超时时间
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName()+"paymentInfo_Timeout,id" + id+"\t" + "O(∩_∩)O哈哈~";

    }


    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池" + Thread.currentThread().getName()+"paymentInfo_Timeout,id" + id+"\t" + "哭哭~";
    }

    //=============服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10" ), ////打开断路器的单位时间内最小请求数 秒
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期 开启断路器的单位时间毫秒
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") //开启断路器的最小失败率60%



    })
    public String paymentCircuitBreaker(Integer id){
        if(id <0 ){
            throw new RuntimeException("************id,不能为负数");
        }
        String seriNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功"+seriNumber;
    }

    public String paymentCircuitBreakerHandler(Integer id){
        return "************paymentCircuitBreakerHandler ===id,不能为负数";
    }
}
