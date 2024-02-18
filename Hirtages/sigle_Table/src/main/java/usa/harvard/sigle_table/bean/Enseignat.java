package usa.harvard.sigle_table.bean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("PROF")
public class Enseignat extends Personne {
    private String matier;
}
