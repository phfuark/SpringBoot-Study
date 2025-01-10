package com.study.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.api.models.Person;

@RestController
public class Controller {

    @GetMapping("")
    public String HelloWord(){
        return "Hello Word";
    }

    @GetMapping("BemVinda")
    public String BemVinda(){
        return "Bem vindo(a)";
    }

    @GetMapping("BemVinda/{nome}")
    public String BemVinda(@PathVariable String nome){
        return "Bem vindo(a) " + nome;
    }

    @PostMapping("/person")
    public Person person(@RequestBody Person person){
        return person;
    }

}