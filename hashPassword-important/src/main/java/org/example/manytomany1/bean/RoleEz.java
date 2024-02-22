package org.example.manytomany1.bean;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RoleEz {
    @Id @GeneratedValue
    private Long id;
    private String id_UUDI;
    private String description;
    // dans la base donne Sql le mots cle DESC est un mots reserver
    // private String desc;
    private String rolename;
    @ManyToMany
    private List<UserEz> userEzList;
}








