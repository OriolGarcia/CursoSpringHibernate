package com.example.aopdemo.dao;

import com.example.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
        private String name;
        private String serviceCode;

    public String addAccount(Account theAccount,boolean vipFlag){

        System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");

        return "okey";
    }

    public boolean doWork(){
        System.out.println(getClass()+": doWork()");
            return false;

    }

    public String getName() {
        System.out.println(getClass()+": ingetName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in SetName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in Get SeviceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in Set Service Code()");
        this.serviceCode = serviceCode;
    }
}
