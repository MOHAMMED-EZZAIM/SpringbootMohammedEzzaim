package usa.harvard.sigle_table.bean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enseignat extends Personne {
    private String matier;
}
