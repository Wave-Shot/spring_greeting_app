package com.brigelabz.spring_greeting_app.service;

import com.brigelabz.spring_greeting_app.model.Greeting;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GreetingService {

    private Map<Long, Greeting> repo = new HashMap<>();
    private long counter = 1;

    public Greeting saveGreeting(String firstName, String lastName) {

        String message;

        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            message = "Hello " + firstName;
        } else if (lastName != null) {
            message = "Hello " + lastName;
        } else {
            message = "Hello World";
        }

        Greeting greeting = new Greeting(counter++, message);
        repo.put(greeting.getId(), greeting);

        return greeting;
    }

    public Greeting findById(long id) {
        return repo.get(id);
    }

    public List<Greeting> findAll() {
        return new ArrayList<>(repo.values());
    }
}