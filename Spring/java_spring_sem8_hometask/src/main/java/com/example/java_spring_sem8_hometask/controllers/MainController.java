package com.example.java_spring_sem8_hometask.controllers;

import com.example.java_spring_sem8_hometask.services.MainService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MainController {

    private final MainService service;

    @GetMapping
    public ResponseEntity<String> method1() {
        String body = service.method1();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/2/{x}")
    public ResponseEntity<String> method2(@PathVariable int x) {
        String body = service.method2(x);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/3/{x}/{y}")
    public ResponseEntity<String> method3(@PathVariable int x, @PathVariable int y) {
        String body = service.method3(x, y);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
