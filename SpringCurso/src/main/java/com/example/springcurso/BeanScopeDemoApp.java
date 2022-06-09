package com.example.springcurso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
 public static void main(String[] args) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
            Coach theCoach = context.getBean("myCoach",Coach.class);
            System.out.println(theCoach.getDailyWorkout());

            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDaylyFortune());
            Coach theCoach2 = context.getBean("myCoach",Coach.class);

            System.out.println(theCoach2.getDailyWorkout());
            System.out.println(theCoach2.getDaylyFortune());
            // SpringApplication.run(SpringCursoApplication.class, args);
            boolean result=theCoach==theCoach2;
            System.out.println(theCoach2.getEmailAddress());
            System.out.println(theCoach2.getTeam());
            System.out.println("\nPoinating to the same object"+result);
            System.out.println("\nMemory location for the Coach" + theCoach);
     System.out.println("\nMemory location for the Coach" + theCoach2 +"\n");
            context.close();
}
}
