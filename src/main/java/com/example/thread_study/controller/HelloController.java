package com.example.thread_study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : limeng
 * @date : 2023/3/22
 * @description :
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("helloWorld")
    public String test() {
        return "hello world";
    }

}
