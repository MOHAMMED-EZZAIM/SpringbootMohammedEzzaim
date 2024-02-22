package org.example.manytomany.dao;
import org.example.manytomany.bean.RoleEz;
import org.example.manytomany.bean.UserEz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserDao extends JpaRepository<UserEz,String> {
    UserEz findByUsername(String name);
    UserEz findByRoleEzs(RoleEz roleEz);
}
