package org.example.manytomany1.service;

import org.example.manytomany1.bean.RoleEz;
import org.example.manytomany1.bean.UserEz;
import org.springframework.stereotype.Service;
@Service
public interface UserService {
    UserEz addNewUser(UserEz userEz);
    RoleEz addNewRole(RoleEz roleEz);

    UserEz findUserByUserName(String name);
    RoleEz findRoleByName(String roleName);
    void addRoleToUser(String userName,String roleName);
}
