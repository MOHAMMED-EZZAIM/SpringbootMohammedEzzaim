package org.example.manytomany.service;
import org.example.manytomany.bean.RoleEz;
import org.example.manytomany.bean.UserEz;
import org.example.manytomany.dao.RoleDao;
import org.example.manytomany.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;
@Service
@Transactional

public class UserServiceImpl implements UserService{

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    private final UserDao userDao;
    private final RoleDao roleDao;


    @Override
    public UserEz addNewUser(UserEz userEz) {
        userEz.setUserId(UUID.randomUUID().toString());
       // hacher le password et envoyer a la base donne
        return userDao.save(userEz);
    }
    @Override
    public RoleEz addNewRole(RoleEz roleEz) {
        return roleDao.save(roleEz);
    }
    @Override
    public UserEz findUserByUserName(String username) {
        UserEz userEz =userDao.findByUsername(username);
        return userEz;
    }

    @Override
    public RoleEz findRoleByName(String roleName){
        return roleDao.findByRolename(roleName);
    }
    @Override
    public void addRoleToUser(String userName, String roleName) {
        UserEz userEz = findUserByUserName(userName);
        RoleEz roleEz = findRoleByName(roleName);
        if (userEz != null && roleEz != null) {
            if (userEz.getRoleEzs() == null) {
                userEz.setRoleEzs(new ArrayList<>());
            }
            userEz.getRoleEzs().add(roleEz);
            if (roleEz.getUserEzList() == null) {
                roleEz.setUserEzList(new ArrayList<>());
            }
            roleEz.getUserEzList().add(userEz);
            userDao.save(userEz);
            roleDao.save(roleEz);
        }
    }

}
