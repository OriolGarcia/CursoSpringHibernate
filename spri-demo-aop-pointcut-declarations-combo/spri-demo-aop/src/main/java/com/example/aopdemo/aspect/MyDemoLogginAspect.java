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
// crate point cut for getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*( ..))")
    private void getter(){}

// crate point cut for setter methods{
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*( ..))")
    private void setter(){}
// exclude getter setter
    @Pointcut("forDaoPackage() && ! (getter()||setter())")
    private void forDAoPackageNoGetterSetter()    {}

   @Before("forDAoPackageNoGetterSetter()")
   public void beforeAddAccountAdvice(){
       System.out.println("\n=====> Excecutin @Before advice on method 1");
   }


    @Before("forDAoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>Performing API analytics");
    }
}
