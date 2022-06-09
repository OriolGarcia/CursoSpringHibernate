package com.example.spridemoannotations2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        //load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retriv benn from sppring container
        Coach theCoach= context.getBean("tennisCoach",Coach.class);
        Coach alphaCoach= context.getBean("tennisCoach",Coach.class);
        // check if they are the same

        boolean result =(theCoach== alphaCoach);
        System.out.println("\n Pointing to the same object:" + result);

        System.out.println("Memory lcoation for the Coach"+ theCoach);

        System.out.println("Memory lcoation for the alphaCoach"+ alphaCoach);
    }
}
