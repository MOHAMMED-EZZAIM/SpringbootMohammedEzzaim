package org.example.projectspringez.dao;

import org.example.projectspringez.bean.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
