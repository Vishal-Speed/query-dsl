package com.example.service;

import com.example.entity.Person;
import com.example.entity.QPerson;
import com.example.repository.PersonRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> findPeople(String name, Integer minAge) {
        QPerson person = QPerson.person;
        Predicate predicate = person.name.contains(name).and(person.age.goe(minAge));
        return (List<Person>) personRepository.findAll(predicate);
    }

    public List<Person> findByName(String name) {
        QPerson person = QPerson.person;
        BooleanExpression eq = person.name.eq(name);
        return (List<Person>) personRepository.findAll(eq);
    }

    public List<Person> findAdults(){
        QPerson person = QPerson.person;
        Predicate predicate = person.age.goe(18);
        return (List<Person>) personRepository.findAll(predicate);
    }
}
