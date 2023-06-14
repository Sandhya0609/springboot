package com.sandhya.librarymanagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

//@Value("${spring.info}")
    private String message=" Welcome Java";

@GetMapping("/hello")
    public String getInfo(){

    return this.message;
    }
}
