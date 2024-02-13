package usa.harvard.tp1_commande.ws.dto;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import usa.harvard.tp1_commande.bean.Commande;
import java.time.LocalDateTime;
@Data
public class PaiementDto {
    private Long id;
    private String code;
    private LocalDateTime datePaiement ;
    @ManyToOne
    private String typePaiement;
    private  boolean encaissement ;
    @ManyToOne
    private Commande commande ;
}
