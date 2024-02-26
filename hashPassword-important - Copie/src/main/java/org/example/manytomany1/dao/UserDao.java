package org.example.manytomany1.dao;

import org.example.manytomany1.bean.RoleEz;
import org.example.manytomany1.bean.UserEz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEz,Long> {
    UserEz findByUsername(String name);
    UserEz findByRoleEzs(RoleEz roleEz);
}
