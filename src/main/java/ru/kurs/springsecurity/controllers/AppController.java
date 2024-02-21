package ru.kurs.springsecurity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kurs.springsecurity.models.Application;
import ru.kurs.springsecurity.service.AppService;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor
public class AppController {
    private AppService service;

    @GetMapping("/welcome")
    public  String welcome(){
        return "Welcome to the unprotected page";
    }
    @GetMapping("/all-app")
    public List<Application> allApplications(){
        return service.allApplications();
    }

    @GetMapping("/{id}")
    public Application applicationByID(@PathVariable int id){
        return service.applicationByID(id);
    }
}
