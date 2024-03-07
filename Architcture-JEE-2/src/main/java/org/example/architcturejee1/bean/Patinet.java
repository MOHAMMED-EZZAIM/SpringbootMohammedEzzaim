package org.example.architcturejee1.bean;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Patinet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNassance;
    private  boolean malade;
    private int score;
}
