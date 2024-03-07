package org.example.bankapplicationbackend.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.bankapplicationbackend.enums.AcountStatus;
import org.example.bankapplicationbackend.enums.AcountStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", length = 4, discriminatorType = DiscriminatorType.STRING)
@Data @AllArgsConstructor @NoArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    // cette enum donc en donne 0 1 2 pour les type enum si en faire cette @Enumerated donne chaine de caratere
    @Enumerated(EnumType.STRING)
    private AcountStatus status;
    @ManyToOne
    private Customer customer;
    //charger en debut tout les donner et les objects qui a des relation de transaction ManyToOne OneToMany ..
//    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.EAGER)

    // hade  LAZY tatcharger 4i donner 3adiyine walakine laderty getAcountOperationList  tatgib lik object
    @OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperationList;
}
