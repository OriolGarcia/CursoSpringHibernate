package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        /// read spring config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
        // call the business metthod
        Account account= new Account();
        theAccountDAO.addAccount(account,true);
        theAccountDAO.doWork();

        //call membershi business metohd
        theMembershipDAO.addMember();
        theMembershipDAO.goSleep();

        // //close the contex
        context.close();
    }
}
