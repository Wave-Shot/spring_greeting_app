package com.brigelabz.spring_greeting_app.controller;

import com.brigelabz.spring_greeting_app.model.Greeting;
import com.brigelabz.spring_greeting_app.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService service;

    public GreetingController(GreetingService service) {
        this.service = service;
    }

    @PostMapping
    public Greeting saveGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        return service.saveGreeting(firstName, lastName);
    }

    @GetMapping("/{id}")
    public Greeting getById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Greeting updateGreeting(
            @PathVariable long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        return service.updateGreeting(id, firstName, lastName);
    }
}