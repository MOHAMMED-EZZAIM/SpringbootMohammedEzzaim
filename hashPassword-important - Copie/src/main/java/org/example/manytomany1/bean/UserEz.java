package org.example.manytomany1.bean;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEz {
    @Id @GeneratedValue
    private  Long userId;
    private String id_UDDI;
    private String username;
    private String password;
    @ManyToMany
    private List<RoleEz> roleEzs;
}
