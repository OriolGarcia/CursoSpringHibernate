package com.example.springcurso;

import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach theCoach = context.getBean("myCoach",Coach.class);
        System.out.println(theCoach.getDailyWorkout());

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDaylyFortune());
        Coach theCoach2 = context.getBean("myCricketCoach",Coach.class);

        System.out.println(theCoach2.getDailyWorkout());
        System.out.println(theCoach2.getDaylyFortune());
        // SpringApplication.run(SpringCursoApplication.class, args);

        System.out.println(theCoach2.getEmailAddress());
        System.out.println(theCoach2.getTeam());
        context.close();
    }
}
