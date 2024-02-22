package org.example.projectspringez.service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.projectspringez.bean.Questios;
import org.example.projectspringez.dao.QustionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
@Service
public class QustionService {
    public Questios save(Questios questios) {
        return qustionDao.save(questios);
    }
    @Autowired
    private  QustionDao qustionDao;

//    public  List<Questios> getAllQuestios() {
//        return qustionDao.findAll();
//    }
public ResponseEntity<List<Questios>> getAllQuestios() {
    try{
        return new ResponseEntity<>(qustionDao.findAll(), HttpStatus.OK);
    }catch(Exception e){
            e.printStackTrace();
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
}
    public ResponseEntity<List<Questios>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(qustionDao.findByCategories(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }
    public ResponseEntity<String> addQuestions(Questios questios) {
        qustionDao.save(questios);
        return new ResponseEntity<>("success!",HttpStatus.CREATED);
    }
}
