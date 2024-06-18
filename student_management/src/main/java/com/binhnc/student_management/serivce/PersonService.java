package com.binhnc.student_management.serivce;

import com.binhnc.student_management.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final ObjectMapper objectMapper;

    @Autowired
    public PersonService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String serializePerson(Person person) throws JsonProcessingException {
        return objectMapper.writeValueAsString(person);
    }

    public Person deserializePerson(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, Person.class);
    }
}