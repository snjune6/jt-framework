package com.link.jk.jkframework.controller;

import com.link.jk.jkframework.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@RestController
public class DemoController {

    private TestService testService;


    @GetMapping(value = "/tests")
    public List<HashMap<String, Object>> getTests() {
        return testService.getTests();
    }

    @GetMapping(value = "/testDao")
    public List<HashMap<String, Object>> getTestDao() {
        return testService.getTestsWithDao();
    }

}
