package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        /// read spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        // call method to find accounts
        boolean tripWire= false;
        List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);
  

        System.out.println("Main Program: After Returning Demo App");
        System.out.println("-----------");

        System.out.println(theAccounts);
        // //close the contex
        context.close();
    }
}
