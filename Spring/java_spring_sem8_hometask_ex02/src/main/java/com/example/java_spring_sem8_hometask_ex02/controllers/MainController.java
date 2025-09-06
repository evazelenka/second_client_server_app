package com.example.java_spring_sem8_hometask_ex02.controllers;

import com.example.java_spring_sem8_hometask_ex02.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class MainController {
    private final MainService service;

    @GetMapping("/register/{id}")
    public ResponseEntity<String> register(@PathVariable int id){
        String serviceResponse = service.register(id);
        ResponseEntity<String> response;
        if (serviceResponse == null){
            response = new ResponseEntity<>("Wrong id", HttpStatus.BAD_REQUEST);
        } else {
            response = new ResponseEntity<>("Registration done successfully", HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/logIn/{id}")
    public ResponseEntity<String> logIn(@PathVariable int id){
        String serviceResponse = service.logIn(id);
        ResponseEntity<String> response;
        if (serviceResponse == null){
            response = new ResponseEntity<>("Wrong id", HttpStatus.BAD_REQUEST);
        } else {
            response = new ResponseEntity<>("" +
                    "LogIn done successfully", HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/logOut/{id}")
    public ResponseEntity<String> logOut(@PathVariable int id){
        String serviceResponse = service.logOut(id);
        ResponseEntity<String> response;
        if (serviceResponse == null){
            response = new ResponseEntity<>("Wrong id", HttpStatus.BAD_REQUEST);
        } else {
            response = new ResponseEntity<>("" +
                    "LogOut done successfully", HttpStatus.OK);
        }
        return response;
    }
}
