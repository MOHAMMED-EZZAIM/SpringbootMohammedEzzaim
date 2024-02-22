package org.example.projectspringez.service;

import org.example.projectspringez.bean.QuestionWrapper;
import org.example.projectspringez.bean.Questios;
import org.example.projectspringez.bean.Quiz;
import org.example.projectspringez.dao.QuizDao;
import org.example.projectspringez.dao.QustionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz= quizDao.findById(id);
       List<Questios> questionfromDB=quiz.get().getQuestios();
       List<QuestionWrapper> questionForUsre =new ArrayList<>();
       for(Questios q: questionfromDB){
        QuestionWrapper qw=new QuestionWrapper(
                q.getId(),
                q.getQuestionTirle(),
                q.getOptions1(),
                q.getOptions2(),
                q.getOptions3(),
                q.getOptions4()
        );
           questionForUsre.add(qw);

       }
       return  new ResponseEntity<>(questionForUsre,HttpStatus.OK);
    }
//    public List<Questios> findByCategoryNumQuestionTitle(String category,  String title) {
//        return qustionDao.findByCategoryNumQuestionTitle(category, title);
//    }
}
