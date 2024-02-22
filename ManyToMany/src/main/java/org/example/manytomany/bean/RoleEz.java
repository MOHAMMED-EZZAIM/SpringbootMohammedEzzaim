package org.example.manytomany.bean;
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
    @Id
    private String id;
    private String desc;
//    @Column(length = 20,unique = true)
    private String rolename;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<UserEz> userEzList;
}








