package com.study.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.api.models.Person;
import com.study.api.repository.Repository;
import com.study.api.service.PersonService;



@RestController
public class Controller {

    @Autowired
    private Repository action;

    @Autowired
    private PersonService service;
    
    @PostMapping("/api")
    public ResponseEntity<?> cadastar(@RequestBody Person objectPerson){
        return service.register(objectPerson);
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

    @DeleteMapping("/api/{code}")
    public void remove(@PathVariable int code){
        Person obj = selectByCode(code);
        action.delete(obj);
    }


    @GetMapping("/api/counter")
    public long counter(){
        return action.count();
    }

    @GetMapping("/api/sortAge")
    public List<Person> sortAge(){
        return action.findByOrderByAge();
    } 

    @GetMapping("/api/Paulos")
    public List<Person> pauloSortAge(){
        return action.findByNameOrderByAge("Paulo");
    }

    @GetMapping("/api/filter")
    public List<Person> filter(){
        return action.findByNameContaining("Paulo");
    }

    @GetMapping("/api/StartP")
    public List<Person> startWith(){
        return action.findByNameStartsWith("P");
    }
    
    @GetMapping("/api/EndsA")
    public List<Person> endstWith(){
        return action.findByNameEndsWith("A");
    }

    @GetMapping("/api/amountAges")
    public int amountAges(){
        return action.amountAges();
    }
    
    @GetMapping("/api/ageHigh")
    public List<Person> ageHighEquals(){
        return action.ageHigEquals(20);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
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