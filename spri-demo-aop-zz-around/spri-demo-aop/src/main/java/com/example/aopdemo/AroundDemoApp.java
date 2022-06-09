package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        /// read spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        TrafficFortuneService theForuneServie  = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        System.out.println("Calling getFortune");

        String data = theForuneServie.getFortune();

        System.out.println("\nMy forune is"+data);
        System.out.println("Finished");
        // call method to find accounts

        context.close();
    }
}
