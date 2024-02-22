package org.example.projectspringez.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Questios {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String questionTirle;
    private String  options1;
    private String  options2;
    private String  options3;
    private String  options4;
    private String  rightAnswer;
    private String  diffuclt;
    private String categories;

}
