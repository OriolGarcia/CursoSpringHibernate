package com.example.spridemoannotations2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnotationDemoApp {

    public static void main(String[] args){
    //read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from spring container
        Coach theCoach= context.getBean("tennisCoach",Coach.class);
        //call a metoth on the bean
        System.out.println(theCoach.getDailyWorkout());
        // call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());
        //close context
        context.close();
    }
}
