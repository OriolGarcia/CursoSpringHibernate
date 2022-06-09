package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspects {


    @Before("com.example.aopdemo.aspect.LuvaAopExpressions.forDAoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n=====>Performing API analytics");
    }

}
