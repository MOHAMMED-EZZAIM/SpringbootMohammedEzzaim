package org.example.manytomany1.service;

import org.example.manytomany1.bean.RoleEz;
import org.example.manytomany1.bean.UserEz;
import org.springframework.stereotype.Service;
@Service
public interface RoleSerice {
    UserEz addNewUser(UserEz userEz);
    RoleEz addnewRole(RoleEz roleEz);

}
