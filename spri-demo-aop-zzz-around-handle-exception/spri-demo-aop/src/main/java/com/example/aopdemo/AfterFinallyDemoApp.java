package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        /// read spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        // call method to find accounts
        List<Account> theAccounts=null;
        try {
            boolean tripWire = false;
             theAccounts= theAccountDAO.findAccounts(tripWire);
        }catch (Exception exc){
            System.out.println("\n\nMain program... caught exception"+exc);
        }

        System.out.println("Main Program: After finally Demo App");
        System.out.println("-----------");

        System.out.println(theAccounts);
        // //close the contex
        context.close();
    }
}
