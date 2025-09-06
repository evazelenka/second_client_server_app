package com.example.java_spring_sem8_hometask.services;

import org.springframework.stereotype.Service;

@Service
public class MainService {


    public String method1(){
        return "Method1 executed";
    }

    public String method2(int x) {
        StringBuilder sb = new StringBuilder();
        if (x <= 0) return "null";
        else {
            for (int i = 1; i < x; i++) {
                char c = (char) i;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String method3(int x, int y){
        StringBuilder sb = new StringBuilder();
        if( x <= 0 || y <= 0) return "null";
        else {
            for (int i = 1; i < x; i++) {
                for (int j = 1; j < y; j++) {
                    char c = (char) (i + j);
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
