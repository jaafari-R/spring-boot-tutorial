package com.ramadan.tut.springboot.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println(getClass().getSimpleName());
    }

    @PostConstruct
    public void start() {
        System.out.println(getClass().getSimpleName() + " Started!");
    }

    @PreDestroy
    public void end() {
        System.out.println(getClass().getSimpleName() + " Ended!");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }
}
