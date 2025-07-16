package org.example.lec1;

import java.util.Arrays;
import java.util.List;

public class UserMain {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(new User("Masha", 19), new User("Tanya", 34), new User("Pavel", 48), new User("Viktor", 64), new User("Marina", 25));
        users.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 25).forEach(System.out::println);
    }
}
