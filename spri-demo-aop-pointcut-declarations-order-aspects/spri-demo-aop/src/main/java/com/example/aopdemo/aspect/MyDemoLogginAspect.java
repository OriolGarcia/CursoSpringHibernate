package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {


   @Before("com.example.aopdemo.aspect.LuvaAopExpressions.forDAoPackageNoGetterSetter()")
   public void beforeAddAccountAdvice(){
       System.out.println("\n=====> Excecutin @Before advice on method 1");
   }



}
