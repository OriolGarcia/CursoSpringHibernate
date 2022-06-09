package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvaAopExpressions {


    @Pointcut("execution(* com.example.aopdemo.dao.*.*( ..))")
    public void forDaoPackage(){
        System.out.println("\n=====> Excecutin @Before advice on method  0");
    }
    // crate point cut for getter methods
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*( ..))")
    public void getter(){}

    // crate point cut for setter methods{
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*( ..))")
    public void setter(){}
    // exclude getter setter
    @Pointcut("forDaoPackage() && ! (getter()||setter())")
    public void forDAoPackageNoGetterSetter()    {}
}
