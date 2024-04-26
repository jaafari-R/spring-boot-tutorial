package com.ramadan.springboot.tut.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    
    @GetMapping("/")
    public String helloWorld() {
        return "<h1>Hello World</h1>";
    }
}
