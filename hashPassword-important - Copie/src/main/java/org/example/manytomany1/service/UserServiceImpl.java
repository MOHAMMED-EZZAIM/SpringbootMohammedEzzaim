package org.example.manytomany1.service;
import org.example.manytomany1.bean.RoleEz;
import org.example.manytomany1.bean.UserEz;
import org.example.manytomany1.dao.RoleDao;
import org.example.manytomany1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.UUID;
@Service
@Transactional

public class UserServiceImpl implements UserService{

    @Autowired
    private  UserDao userDao;
    @Autowired
    private  RoleDao roleDao;
    @Override
    public UserEz addNewUserWithHash(UserEz userEz) {
//        userEz.setId_UDDI(UUID.randomUUID().toString());
        userEz.setId_UDDI(UUID.randomUUID().toString().substring(0,8));
        // hacher le password et envoyer a la base donne
        // Hacher le mot de passe avec BCrypt
        String plainPassword = userEz.getPassword(); // Supposons que le mot de passe soit stocké dans userEz
        String hashedPassword = hashPassword(plainPassword);
        userEz.setPassword(hashedPassword);

        // Enregistrer l'utilisateur dans la base de données
        return userDao.save(userEz);
    }
    public UserEz addNewUsersansash(UserEz userEz) {
        userEz.setId_UDDI(UUID.randomUUID().toString().substring(0,8));
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
    @Override
public UserEz authenticateWithHash(String username, String password) {
       UserEz userEz=findUserByUserName(username);
     System.out.println(userEz.getUsername());
     System.out.println(userEz.getPassword());
     System.out.println(hashPassword(password));
       if(userEz==null){
           throw new RuntimeException("Bade credentils");
       }
        if(userEz.getPassword().equals(hashPassword(password))){
           return  userEz;
       }
     else {
           throw new RuntimeException("Bade credentils  autre");
     }
   }

    @Override
    public UserEz authenticateSansHash(String username, String password) {
        return null;
    }







//    @Override
//    public UserEz authenticateSansHash(String username, String password) {
//        UserEz userEz=findUserByUserName(username);
//        if(userEz==null){
//            throw new RuntimeException("Bade credentils");
//        }
//        if(userEz.getPassword().equals(password)){
//            return  userEz;
//        }
//        else {
//            throw new RuntimeException("Bade credentils  autre");
//        }
//    }
}
