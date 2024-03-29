package usa.harvard.sigle_table.bean;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Type",length = 4)
public abstract class Personne {
    @Id
    private Long id;
    private String nom;
    private String dateNaissance;
}
