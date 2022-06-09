package com.example.springcurso;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    private String emailAddress;
    private String team;
    public CricketCoach(){
        System.out .println(("CricketCoatch : insde constructor"));



    }
    @Override
    public String getDailyWorkout(){
        return "Practice fasl bowling fo 15 minutes";
    }
    @Override
    public String getDaylyFortune(){
        return fortuneService.getFortune();
    }
    public void setFortuneService(FortuneService fortuneService){
        this.fortuneService=fortuneService;

    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out .println(("CricketCoatch : insde setter method - setEmailAddress"));
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out .println(("CricketCoatch : insde setter method - setTeam"));
        this.team = team;
    }
}
