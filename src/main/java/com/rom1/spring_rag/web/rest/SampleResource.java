package com.rom1.spring_rag.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SampleResource {

    @GetMapping("/samples/{value}")
    public String hello(@PathVariable(value = "value", required = false) final String value) {
        return "Hello " + value + "!";
    }
}
