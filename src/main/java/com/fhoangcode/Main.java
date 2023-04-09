package com.fhoangcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/")
    public GreetResponse greet() {
        String greet;
        String name;
        GreetResponse response = new GreetResponse(
                greet = "Hello",
                List.of("Java", "Golang", "Javascript"),
                new Person(name = "Alex")
        );
        return response;
    }
    record Person (String name){
    }
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguage,
            Person person
    ){
    }


}
