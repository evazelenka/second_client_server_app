package ru.geekbrains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.config.ProjectConfig;
import ru.geekbrains.domain.Car;
import ru.geekbrains.domain.Engine;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Car car = context.getBean("reno", Car.class);
        System.out.println(car);

        Engine e = context.getBean(Engine.class);
        System.out.println(e);

    }
}
