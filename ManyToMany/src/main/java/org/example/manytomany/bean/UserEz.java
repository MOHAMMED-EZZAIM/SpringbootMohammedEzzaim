package org.example.manytomany.bean;
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
    @Id
    private  String userId;

//    @Column(name = "USER_Name",unique = true,length = 20)
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<RoleEz> roleEzs;
}
