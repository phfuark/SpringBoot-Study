package com.study.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.study.api.models.Mensage;
import com.study.api.models.Person;
import com.study.api.repository.Repository;

@Service
public class PersonService{

    @Autowired
    private Mensage mensage;
    
    @Autowired
    private Repository action;
    


    public ResponseEntity<?> register(Person objectPerson){
        
        if (objectPerson.getName().equals("")){
            mensage.setMensage("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else if (objectPerson.getAge() < 0){
            mensage.setMensage("A idade deve ser maior que 0");
            return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(action.save(objectPerson), HttpStatus.CREATED);
        }
    }
    
}
