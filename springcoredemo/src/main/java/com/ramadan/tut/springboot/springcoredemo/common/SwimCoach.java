package com.ramadan.tut.springboot.springcoredemo.common;

public class SwimCoach implements Coach {
    
    public SwimCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1km as a warm up";
    }
}
