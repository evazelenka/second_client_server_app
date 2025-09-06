package com.example.java_spring_sem8_hometask_ex02.services;

import com.example.java_spring_sem8_hometask_ex02.aspects.LogActions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MainService {

    private final Set<Integer> allUsersId = new HashSet<>();
    private final Set<Integer> onlineUsersId = new HashSet<>();

    @LogActions
    public String register(int id){
        if(allUsersId.contains(id) || id <= 0) return null;
        else allUsersId.add(id);
        return "SUCCESS";
    }

    @LogActions
    public String logIn(int id){
        if(!allUsersId.contains(id) || onlineUsersId.contains(id) || id <= 0) return null;
        else onlineUsersId.add(id);
        return "SUCCESS";
    }

    @LogActions
    public String logOut(int id){
        if (onlineUsersId.contains(id)) onlineUsersId.removeIf(v -> v == id);
        else return null;
        return "SUCCESS";
    }
}
