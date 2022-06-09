package com.example.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {



    //Setup logger
    private Logger myLogger= Logger.getLogger((getClass().getName()));
    //setu poin t cut declatratons
    @Pointcut("execution(* com.example.springdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }
    @Pointcut("execution(* com.example.springdemo.service.*.*(..))")
    private void forServicePackage(){

    }
    @Pointcut("execution(* com.example.springdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }
    @Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
    private void forAppFlow(){}
    // add @before advice
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        //display
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> in @Before: calling method:"+theMethod);
       Object[] args = theJoinPoint.getArgs();
       for(Object temparg: args ){
           myLogger.info("=======> argument: "+temparg);

       }
    }
    //add @Afterreturnic advice

    @AfterReturning(pointcut = "forAppFlow()",returning = "theResult")
    public void afterReturnin(JoinPoint theJoinPoint, Object theResult){
        // displar method retunrning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("=============> om @AfterReturning: from method: "+theMethod);


        // dispal data retuned
        myLogger.info("=============> om @AfterReturning: from method: "+theResult);

    }
}
