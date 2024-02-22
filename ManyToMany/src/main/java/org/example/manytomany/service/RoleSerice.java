package org.example.manytomany.service;

import org.example.manytomany.bean.RoleEz;
import org.example.manytomany.bean.UserEz;
import org.springframework.stereotype.Service;
@Service
public interface RoleSerice {
    UserEz addNewUser(UserEz userEz);
    RoleEz addnewRole(RoleEz roleEz);

}
