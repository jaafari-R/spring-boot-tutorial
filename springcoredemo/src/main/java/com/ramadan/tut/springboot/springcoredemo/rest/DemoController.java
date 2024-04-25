package com.ramadan.tut.springboot.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramadan.tut.springboot.springcoredemo.common.Coach;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach myCoach) {
        this.myCoach = myCoach;
    }

    // @Autowired
    // public void setCoach(Coach coach) {
    //     this.myCoach = coach;
    // }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
