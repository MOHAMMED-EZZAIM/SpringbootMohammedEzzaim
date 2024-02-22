package org.example.projectspringez.service;

import org.example.projectspringez.bean.Questios;
import org.example.projectspringez.bean.Quiz;
import org.example.projectspringez.dao.QuizDao;
import org.example.projectspringez.dao.QustionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QustionDao qustionDao;

    public ResponseEntity<String> createQuiz(String category,int numQ) {
        List<Questios> questiosList = qustionDao.findByCategoryNumQuestionTitle(category, PageRequest.of(0, numQ));
        Quiz quiz = new Quiz();
        quiz.setQuestios(questiosList);
        quizDao.save(quiz);
        try {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }


    public List<Quiz> findAll(){
       return quizDao.findAll();
    }
//    public List<Questios> findByCategoryNumQuestionTitle(String category,  String title) {
//        return qustionDao.findByCategoryNumQuestionTitle(category, title);
//    }
}
