package ru.javabegin.training.springlib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringlibApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringlibApplication.class, args);
    }

}
