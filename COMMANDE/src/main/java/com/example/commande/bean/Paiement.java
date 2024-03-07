package com.example.commande.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private LocalDateTime datePaiement;
    double montant;
    private boolean encaissement;
    @ManyToOne
    private TypePaiement  typePaiement ;
    @ManyToOne
    private Commande commande;

}
