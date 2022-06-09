package com.example.spridemoannotations2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
//@ComponentScan("com.example.spridemoannotations2")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService(){

        return new SadFortuneService();

    }

@Bean
    public Coach swimCoach(){
    SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
    return mySwimCoach;

}

}
