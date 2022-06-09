package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {


   @Before("com.example.aopdemo.aspect.LuvaAopExpressions.forDAoPackageNoGetterSetter()")
   public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
       System.out.println("\n=====> Excecutin @Before advice on method 1");

                //display method signatureç
                MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
                System.out.println("Method:" +methodSig);
    //display method arguments

       Object[] args=  theJoinPoint.getArgs();

       for(Object tempArg:args){
           System.out.println(tempArg);

           if (tempArg instanceof Account){

               Account theAccount = (Account)  tempArg;
               System.out.println("account name"+theAccount.getName());
               System.out.println("Account level" +theAccount.getLevel() );
           }
       }
}

}
