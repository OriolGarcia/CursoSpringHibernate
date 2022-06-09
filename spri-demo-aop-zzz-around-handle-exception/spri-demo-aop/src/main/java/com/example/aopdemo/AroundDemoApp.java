package com.example.aopdemo;

import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {
        /// read spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        TrafficFortuneService theForuneServie  = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        System.out.println("Calling getFortune");

        String data = theForuneServie.getFortune(false);

        System.out.println("\nMy forune is"+data);
        System.out.println("Finished");
        // call method to find accounts

        context.close();
    }
}
