package com.phfuark.first_spring_app.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world")
public class HelloWorldController {
    //GET / hello-word
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello Word";
    }
}
