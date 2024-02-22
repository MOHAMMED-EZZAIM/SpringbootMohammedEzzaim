package org.example.projectspringez;

import org.example.projectspringez.bean.Questios;
import org.example.projectspringez.service.QustionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectSpringEzApplication implements CommandLineRunner {
    @Autowired
    private QustionService qustionService;
    public static void main(String[] args) {
        SpringApplication.run(ProjectSpringEzApplication.class, args);
    }
    private Integer id;
    private String questionTirle;
    private String  options1;
    private String  options2;
    private String  options3;
    private String  options4;
    private String  rightAnswer;
    private String  diffuclt;

    @Override
    public void run(String... args) throws Exception {

    }
}
