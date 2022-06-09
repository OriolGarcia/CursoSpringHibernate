package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProcedingJoinPoint) throws Throwable{


        //print
        String method = theProcedingJoinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executin @Araound on method" + method);
        //get timespad
        long begin = System.currentTimeMillis();
        Object result= theProcedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration= end-begin;
        System.out.println("\n =====> Duration"+duration/1000.0 +" seconds");
        return null;
    }



    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))\\\",returning = \\\"result\",throwing = \"theExcec")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executin @After (finally) on method" + method);
        //print out

    }








    @AfterThrowing(pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))\",returning = \"result",throwing = "theExcec")
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint,Throwable theExcec){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executin @After throwing on method" + method);
        //print out
        System.out.println("\n===> the exception is: `"+theExcec);
    }
        // add acvicer after
    @AfterReturning(pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
    public  void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account>result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n ====> Executin @After returning on method" + method);
        System.out.println("\n =============> result is:"+result);
        //let's pst-process the data .... let's modify it


        //convert account names to upercase

        convertAccountNamesToUpperCase(result);
        System.out.println("\n =============> result is:"+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop
        for(Account tempAccount:result){
            // get upper case versions
            String theUpperCase = tempAccount.getName().toUpperCase();
            //update
            tempAccount.setName(theUpperCase);
        }


         }

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
