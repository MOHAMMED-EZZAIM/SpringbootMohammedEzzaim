package org.example.projectspringez.controluer;

import org.example.projectspringez.bean.Quiz;
import org.example.projectspringez.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class Quizcontroller {



    @GetMapping("/")
    public List<Quiz> findAll() {
        return quizService.findAll();
    }

    @Autowired
    private QuizService quizService;
     //   http://localhost:9090/Quiz/create?category=java
    //http://localhost:9090/Quiz/create?category=java&numq=3
    @PostMapping("create")
    public ResponseEntity<String> creatQuiz(@RequestParam String category,@RequestParam int numq) {

        quizService.createQuiz(category,numq);
//        return quizService.creatQuiz(category,numQ,tittle);
        System.out.println("hello mohammed ezzaim!");
        return new ResponseEntity<>("succes!!",HttpStatus.OK);
    }
}
