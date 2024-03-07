package com.example.commande.bean;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String ref;
    private double total;
    private double totalPay;
    double montantPayeCheque;
    double montantPayeEspece;

    @OneToMany
    private List<Paiement> paiement;
}

