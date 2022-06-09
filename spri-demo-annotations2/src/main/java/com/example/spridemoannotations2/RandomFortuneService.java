package com.example.spridemoannotations2;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    private String[] data= {
            "Beware of the wolf in sheep'sclothing",
            "Diligence is the mother of good luck",
            "the journey is the reward"
    };
    private Random myRandom = new Random();


    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);

        String theFortune= data[index];
        return theFortune;
    }
}
