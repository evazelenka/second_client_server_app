package ru.geekbrains.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.geekbrains.domain.Car;
import ru.geekbrains.domain.Engine;

@Configuration
//@ComponentScan(basePackages = "ru.geekbrains.domain")
public class ProjectConfig {

    @Bean
    Engine engine1(){
        Engine engine = new Engine();
        engine.setType("Бензиновый");
        return engine;
    }

    @Bean
    Engine engine2(){
        Engine engine = new Engine();
        engine.setType("Дизельный");
        return engine;
    }

    @Bean(name="BMW")
    @Primary
    Car car(@Qualifier("engine1") Engine engine){
        Car obCar = new Car(engine);
        obCar.setModel("X1");
        obCar.setMade("BMW");
        return obCar;
    }

    @Bean(name="audi")
    Car car2(@Qualifier("engine1") Engine engine){
        Car obCar = new Car(engine);
        obCar.setModel("S8");
        obCar.setMade("audi");
        return obCar;
    }

    @Bean(name="reno")
    Car car3(@Qualifier("engine2") Engine engine){
        Car obCar = new Car(engine);
        obCar.setModel("Logan");
        obCar.setMade("reno");
        return obCar;
    }

//    @Bean
//    String str(){
//        return "Hello";
//    }
//
//    @Bean
//    Integer intgr(){
//        return 10;
//    }
}