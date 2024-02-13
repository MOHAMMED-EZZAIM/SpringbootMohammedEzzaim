package usa.harvard.tp1_commande.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Paiement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private LocalDateTime datePaiement ;
    private double montant;
    private  boolean encaissement ;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private TypePaiement  typePaiement;
    @ManyToOne (cascade = CascadeType.REMOVE)
    private Commande commande ;

}
