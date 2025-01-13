package com.study.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.api.models.Person;
import com.study.api.repository.Repository;

@RestController
public class Controller {

    @Autowired
    private Repository action;
    
    @PostMapping("/api")
    public Person cadastar(@RequestBody Person obj){
        return action.save(obj);
    }

    @GetMapping("/api")
    public List<Person> select(){
        return action.findAll();
    }

    @GetMapping("/api/{code}")
    public Person selectByCode(@PathVariable int code){
        return action.findByCode(code);
    }

    @PutMapping("api")
    public Person edit(@RequestBody Person obj){
        return action.save(obj);
    }

    @GetMapping("")
    public String HelloWord(){
        return "Hello Word";
    }

    // @GetMapping("BemVinda")
    // public String BemVinda(){
    //     return "Bem vindo(a)";
    // }

    // @GetMapping("BemVinda/{nome}")
    // public String BemVinda(@PathVariable String nome){
    //     return "Bem vindo(a) " + nome;
    // }

    // @PostMapping("/person")
    // public Person person(@RequestBody Person person){
    //     return person;
    // }

}