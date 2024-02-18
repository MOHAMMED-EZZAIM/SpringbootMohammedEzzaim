package usa.harvard.sigle_table.bean;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type",length = 4)
public abstract class Personne {
    @Id
    private Long id;
    private String nom;
    private String dateNaissance;
}
