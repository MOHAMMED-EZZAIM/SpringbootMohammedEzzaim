package usa.harvard.sigle_table.bean;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String dateNaissance;
}
