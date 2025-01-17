package com.study.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.study.api.models.Message;
import com.study.api.models.Person;
import com.study.api.repository.Repository;

@Service
public class PersonService{

    @Autowired
    private Message message;
    
    @Autowired
    private Repository action;
    


    // REGISTER PERSONS
    public ResponseEntity<?> register(Person objectPerson){
        
        if (objectPerson.getName().equals("")){
            message.setMessage("O nome precisa ser preenchido");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else if (objectPerson.getAge() < 0){
            message.setMessage("A idade deve ser maior que 0");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(action.save(objectPerson), HttpStatus.CREATED);
        }
    }


    // SELECT PERSONS 
    public ResponseEntity<?> select(){
        return new ResponseEntity<>(action.findAll(), HttpStatus.OK);
    }


    // SELECT BY CODE 
    public ResponseEntity<?> selectByCode(int code){
        if(action.countByCode(code)==0){
            message.setMessage("Pessoa não encontrada.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(action.findByCode(code), HttpStatus.OK);
        }
    }
    

    // EDIT PERSON

    public ResponseEntity<?> edit(Person obj){
        if(action.countByCode(obj.getCode())==0){
            message.setMessage("Pessoa não encontrada, não é possível editar.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else if(obj.getName().equals("")){
            message.setMessage("Nome não definido, não é possível editar.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }else if(obj.getAge() < 0){
            message.setMessage("Idade inválida, não é possível editar.");
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(action.save(obj), HttpStatus.OK);
        }
    }   

    // REMOVE PERSON
    public ResponseEntity<?> remove(int code){
        if(action.countByCode(code)==0){
            message.setMessage("Código não existente, não é possível remover.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else{
            Person obj = action.findByCode(code);
            action.delete(obj);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}