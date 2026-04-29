package com.example.javavaapr.week3.rest.controller;


import com.example.javavaapr.week3.rest.domain.DemoPojo;
import com.example.javavaapr.week3.rest.domain.GeneralResponse;
import com.example.javavaapr.week3.rest.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    public ResponseEntity<String> getDemoResponse(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getDemoPathVariable(@PathVariable String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> testPost(@RequestBody DemoPojo pojo) {
        DemoPojo resPojo = demoService.process(pojo);
        DemoPojo emptyPojo = new DemoPojo();
        GeneralResponse response = new GeneralResponse(new Date(), Arrays.asList(resPojo, emptyPojo));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
