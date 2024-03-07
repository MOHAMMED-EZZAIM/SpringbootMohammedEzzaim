package org.example.bankapplicationbackend.bean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@DiscriminatorValue("SA")
@Data @AllArgsConstructor @NoArgsConstructor
public class SavingAcount extends BankAccount{
    private double interestRat;
}
