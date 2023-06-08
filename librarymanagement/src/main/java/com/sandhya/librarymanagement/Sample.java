package com.sandhya.librarymanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

@GetMapping("/hello")
    public String getInfo(){
        return "Welcome to Spring ";
    }
}
