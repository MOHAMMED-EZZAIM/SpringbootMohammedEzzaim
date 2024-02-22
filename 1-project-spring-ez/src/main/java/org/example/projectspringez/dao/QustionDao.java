package org.example.projectspringez.dao;
import org.example.projectspringez.bean.Questios;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QustionDao extends JpaRepository<Questios,Long> {

    @Query("SELECT q FROM Questios q WHERE q.categories = :category  ")
    List<Questios> findByCategoryNumQuestionTitle(@Param("category") String category,@Param("numQ") PageRequest numQ);

    List<Questios> findAll();

    List<Questios> findByCategories(String category);
}
