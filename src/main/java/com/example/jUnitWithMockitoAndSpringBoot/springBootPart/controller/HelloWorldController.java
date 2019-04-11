package com.example.jUnitWithMockitoAndSpringBoot.springBootPart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dkorolev
 *         Date: 4/11/2019
 *         Time: 2:10 PM
 */
@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello, World";
    }

}