package com.study.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.study.api.models.Person;

public interface Repository extends CrudRepository<Person, Integer>{

    @SuppressWarnings("null")
    @Override
    List<Person> findAll();

    Person findByCode(int code);

    List<Person> findByOrderByAge();

    List<Person> findByNameOrderByAge(String name);

    List<Person> findByNameContaining(String term);

    List<Person> findByNameStartsWith(String term);
    List<Person> findByNameEndsWith(String term);
}
