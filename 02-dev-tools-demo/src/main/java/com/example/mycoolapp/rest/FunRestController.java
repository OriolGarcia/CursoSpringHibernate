package com.example.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @GetMapping("/")
    private String sayHello(){
        return "Hello World Time on server is "+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){

        return "Run a hard 5k!";
    }
    @GetMapping("/fortune")
    public String getDailyFortune(){

        return "Today is your lucky day.";
    }
}
