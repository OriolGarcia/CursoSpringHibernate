package com.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember(){

        System.out.println(getClass()+": DOING STUFF: ADDING MEMEBERSHIP ACCOUNT");
        return false;
    }

    public void goSleep(){
        System.out.println(getClass()+": I'm going to sleep now...");

    }
}
