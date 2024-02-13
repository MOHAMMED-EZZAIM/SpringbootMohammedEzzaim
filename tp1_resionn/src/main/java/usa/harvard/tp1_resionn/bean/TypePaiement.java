package usa.harvard.tp1_resionn.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypePaiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String code ;
    private  String libelle;
}
