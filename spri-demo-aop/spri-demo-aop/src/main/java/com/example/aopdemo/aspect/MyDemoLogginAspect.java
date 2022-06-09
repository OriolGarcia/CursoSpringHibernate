package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

   @Before("execution(* com.example.aopdemo.dao.*.*( ..))")
   public void beforeAddAccountAdvice(){
       System.out.println("\n=====> Excecutin @Before advice on method");
   }



}
