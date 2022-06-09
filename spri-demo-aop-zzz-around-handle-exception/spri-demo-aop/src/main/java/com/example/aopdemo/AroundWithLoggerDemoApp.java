package com.example.aopdemo;

import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {
        /// read spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        TrafficFortuneService theForuneServie  = context.getBean("trafficFortuneService",TrafficFortuneService.class);
        myLogger.info("Calling getFortune");

        String data = theForuneServie.getFortune( );

        myLogger.info("\nMy fortune is"+data);
        myLogger.info("Finished");
        // call method to find accounts

        context.close();
    }
}
