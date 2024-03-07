package com.example.commande.ws.dto;

import com.example.commande.bean.Commande;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PaiementDto {
    private Long id;
    private String code;
    private LocalDateTime datePaiement;
    double montant;
    private boolean encaissement;
    private Commande commande;

}
