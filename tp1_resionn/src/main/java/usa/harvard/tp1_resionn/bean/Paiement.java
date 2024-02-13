package usa.harvard.tp1_resionn.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private LocalDateTime datePaiement ;
    private double montant;
    private  boolean encaissement ;

    @ManyToOne
    private TypePaiement typePaiement;
    @ManyToOne
    private Commande commande ;
}
