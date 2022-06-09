package com.example.springcurso;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public TrackCoach(FortuneService theFortuneService){
        this.fortuneService = theFortuneService;

    }
    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting  practice";
    }
    @Override
    public String getDaylyFortune(){
        return "Just Do It "+fortuneService.getFortune();
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

    public void doMyStartupStuff(){

        System.out.println("TrackCoach:insice method doMyStartupStuff");
    }

    public void doMyCleanupStuffYoYo(){

        System.out.println("TrackCoach:insice method doMyCleanupStuffYoYo");
    }
}
