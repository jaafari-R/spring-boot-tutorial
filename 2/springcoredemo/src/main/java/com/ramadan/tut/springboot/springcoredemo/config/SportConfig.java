package com.ramadan.tut.springboot.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ramadan.tut.springboot.springcoredemo.common.Coach;
import com.ramadan.tut.springboot.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
    
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
