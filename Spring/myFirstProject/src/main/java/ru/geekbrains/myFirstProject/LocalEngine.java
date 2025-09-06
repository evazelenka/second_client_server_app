package ru.geekbrains.myFirstProject;

import org.springframework.stereotype.Component;

@Component
public class LocalEngine {
    public LocalEngine() {
        System.out.println("engine is running...");
    }

    public void go(){
        System.out.println("go!");
    }
}
