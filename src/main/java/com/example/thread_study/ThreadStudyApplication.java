package com.example.thread_study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.thread_study.mybatisPlus.mapper")
public class ThreadStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadStudyApplication.class, args);
    }

}
