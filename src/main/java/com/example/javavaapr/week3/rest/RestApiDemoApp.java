package com.example.javavaapr.week3.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestApiDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(RestApiDemoApp.class, args);
    }
}

/**
 *  Spring MVC
 *
 *  -> dispatcher servlet -> handler mapping -> controller -> service ..
 *          |
 *      without response body annotation
 *      view resolver
 *
 *  -> dispatcher servlet -> handler mapping -> controller -> service ..
 *          |
 *      response body annotation
 *      http message converter
 *          |
 *      Jackson convert pojo to json / xml
 */

