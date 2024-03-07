package com.example.commande.ws.dto;

import lombok.Data;

@Data
public class CommandeDto {
    private long id;
    private String ref;
    private double total;
    private double totalPay;

}
