package org.example.manytomany1.service;
import org.example.manytomany1.bean.RoleEz;
import org.example.manytomany1.bean.UserEz;
import org.example.manytomany1.dao.RoleDao;
import org.example.manytomany1.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.ArrayList;
import java.util.UUID;
@Service
@Transactional

public class UserServiceImpl implements UserService{

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }
// mohammed ezzaim
    private final UserDao userDao;
    private final RoleDao roleDao;
    @Override
    public UserEz addNewUser(UserEz userEz) {
        userEz.setUserId(UUID.randomUUID().toString().substring(0,8));
        // hacher le password et envoyer a la base donne


        // Hacher le mot de passe avec BCrypt
        String plainPassword = userEz.getPassword(); // Supposons que le mot de passe soit stocké dans userEz
        String hashedPassword = hashPassword(plainPassword);
        userEz.setPassword(hashedPassword);

        // Enregistrer l'utilisateur dans la base de données
        return userDao.save(userEz);
    }

    private String hashPassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(plainPassword);
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
