package com.example.javavaapr.week3.rest.service;

import com.example.javavaapr.week3.rest.domain.DemoPojo;
import org.springframework.stereotype.Service;

@Service
public interface DemoService {
    DemoPojo process(DemoPojo pojo);
}
