package com.example.springcurso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
 public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beenLifeCycled-applicationContext.xml");
           // Coach theCoach = context.getBean("myCoach",Coach.class);
          // System.out.println(theCoach.getDailyWorkout());
            context.close();
}
}
