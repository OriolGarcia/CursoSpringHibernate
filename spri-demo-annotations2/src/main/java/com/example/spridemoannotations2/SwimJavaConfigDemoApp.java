package com.example.spridemoannotations2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args){
    //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach theCoach= context.getBean("swimCoach",SwimCoach.class);
        //call a metoth on the bean
        System.out.println(theCoach.getDailyWorkout());
        // call method to get daily fortune
        System.out.println(theCoach.getDailyFortune());

        // call our ne swim coache metods

        System.out.println("email: " + theCoach.getEmail());
        System.out.println("team: " + theCoach.getTeam());

        //close context

        //
        context.close();
    }
}
