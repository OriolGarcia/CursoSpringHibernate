package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

    @Pointcut("execution(* com.example.aopdemo.dao.*.*( ..))")
    private void forDaoPackage(){
        System.out.println("\n=====> Excecutin @Before advice on method  0");
    }


   @Before("forDaoPackage()")
   public void beforeAddAccountAdvice(){
       System.out.println("\n=====> Excecutin @Before advice on method 1");
   }


    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n=====>Performing API analytics");
    }
}
