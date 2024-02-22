package org.example.projectspringez.controluer;

import org.example.projectspringez.bean.Questios;
import org.example.projectspringez.dao.QustionDao;
import org.example.projectspringez.service.QustionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Questions")
public class QuistionControleur {
    public QustionDao getQustionDao() {
        return qustionService.getQustionDao();
    }

    public void setQustionDao(QustionDao qustionDao) {
        qustionService.setQustionDao(qustionDao);
    }

//    @GetMapping("/")
//    public List<Questios> getAllQuestios() {
//        return qustionService.getAllQuestios();
//    }

    @GetMapping("/")
    public ResponseEntity<List<Questios>> getAllQuestios() {
        return  qustionService.getAllQuestios();
    }

//    @PostMapping("/save")
//    public Questios save(@RequestBody  Questios questios) {
//        return qustionService.save(questios);
//    }

//    @GetMapping("category/{cat}")
//    public List<Questios> getQuestionsByCategory(@PathVariable("cat")  String category){
//  return  qustionService.getQuestionsByCategory(category);
//    }
@GetMapping("category/{cat}")
public ResponseEntity<List<Questios>> getQuestionsByCategory(@PathVariable("cat")  String category){
    return  qustionService.getQuestionsByCategory(category);
}
    @PostMapping("/saveQuestion")
    public ResponseEntity<String> addQeustion(@RequestBody Questios questios){
        return  qustionService.addQuestions(questios);
    }

    @Autowired
    private QustionService qustionService;

}
