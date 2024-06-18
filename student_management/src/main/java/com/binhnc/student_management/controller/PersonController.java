package com.binhnc.student_management.controller;

import com.binhnc.student_management.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class PersonController {
    @GetMapping("/test-object-mapper")
    public ResponseEntity<?> objectMapper() throws JsonProcessingException {
        // Serialization
        Person person = new Person("John Doe", 30);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        //System.out.println(json); // Output: {"name":"John Doe","age":30}

        // Deserialization
        String jsonString = "{\"name\":\"John Doe\",\"age\":30}";
        Person deserializedPerson = mapper.readValue(jsonString, Person.class);
        System.out.println(deserializedPerson); // Output: Person(name=John Doe, age=30)
        return ResponseEntity.status(HttpStatus.OK).body(jsonString);
    }
}
