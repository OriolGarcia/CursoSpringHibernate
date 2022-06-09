package com.example.spridemoannotations2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach{
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;
   public TennisCoach(){
       System.out.println(">> TenisCoach: inside deault constructor");
   }
// define my init method
    @PostConstruct
    public void  doMyStartupStuff(){
       System.out.println(">> Tenis Coach inside of startupstuff");

    }

    // define my destgroy method
    @PreDestroy
    public void  doMyCleanupStuff(){
        System.out.println(">> Tenis Coach inside of Cleanupstuff");

    }


   /*
   @Autowired
   public void doSomeCrazyStuff(FortuneService theFortuneService){
       System.out.println(">> TenisCoach: inside set FortuneService () method");
       fortuneService=theFortuneService;

   }*/
   /* @Autowired
    public TennisCoach(FortuneService theFortuneService){
        fortuneService=theFortuneService;

    }
    */
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
