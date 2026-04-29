package com.example.javavaapr.week3.rest.service;

import com.example.javavaapr.week3.rest.domain.DemoPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoServiceImpl implements DemoService{

    private final RestTemplate restTemplate;

    public DemoServiceImpl(@Qualifier("getRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DemoPojo process(DemoPojo pojo) {
        pojo.setName("Alex");
        return pojo;
    }
}
