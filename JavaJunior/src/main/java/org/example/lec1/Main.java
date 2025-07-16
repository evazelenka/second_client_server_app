package org.example.lec1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//
//        PlainInterface plainInterface1 = Integer::compare;
//
//        System.out.println(plainInterface1.action(5, 3));

        List<String> list = Arrays.asList("hi", "cat", "bill", "mirror", "window", "ow", "owl", "scream");
//        list = list.stream().filter(str -> str.length() > 2).collect(Collectors.toList());
//        for(String l : list){
//            System.out.println(l);
//        }
        list.stream().filter(str -> str.length() > 2).filter(str -> str.contains("o")).forEach(System.out::println);

        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().map(i -> i * i).forEach(i -> System.out.print(i + " "));

        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().map(i -> "number: " + i + " i^2: " + i*i).forEach(System.out::println);

        Arrays.asList(78,6,10,78,34,15).stream().sorted().distinct().forEach(System.out::println);

        System.out.println(Arrays.asList(78,6,10,78,34,15).stream().sorted().distinct().findFirst().get());

        System.out.println(Arrays.asList(78,6,10,78,34,15).stream().distinct().findFirst().get());
    }
}