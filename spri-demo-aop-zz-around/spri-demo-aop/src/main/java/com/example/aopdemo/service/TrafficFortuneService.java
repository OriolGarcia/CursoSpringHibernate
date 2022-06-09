package com.example.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class TrafficFortuneService {
    public String getFortune(){
        //simulate delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Expect heavy traffic this morning";
    }
}
