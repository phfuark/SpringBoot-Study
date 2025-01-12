package com.study.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.study.api.models.Person;

public interface Repository extends CrudRepository<Person, Integer>{
    
}
