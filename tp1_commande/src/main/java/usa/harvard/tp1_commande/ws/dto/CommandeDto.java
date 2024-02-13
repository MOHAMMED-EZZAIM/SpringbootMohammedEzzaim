package usa.harvard.tp1_commande.ws.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
    public class CommandeDto {
    @Id
    private Long id;
    private String ref;
    private double total;
    private double totalPayer;

}
