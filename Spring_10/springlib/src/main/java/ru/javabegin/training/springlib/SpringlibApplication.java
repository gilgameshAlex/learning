package ru.javabegin.training.springlib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.javabegin.training.springlib"})
@EnableAutoConfiguration
public class SpringlibApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringlibApplication.class, args);
    }

}
