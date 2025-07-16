package org.example.lec1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    String name;
    int age;

    @Override
    public String toString() {
        return "User: " + name + ", " + age;
    }
}
