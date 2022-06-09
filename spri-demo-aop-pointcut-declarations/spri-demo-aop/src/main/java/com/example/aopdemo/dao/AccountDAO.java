package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public String addAccount(Account theAccount,boolean vipFlag){

        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");

        return "okey";
    }

    public boolean doWork(){
        System.out.println(getClass()+": DOING MYDB WORK");
            return false;

    }


}
