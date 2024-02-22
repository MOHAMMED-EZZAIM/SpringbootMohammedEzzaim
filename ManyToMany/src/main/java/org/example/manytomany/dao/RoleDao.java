package org.example.manytomany.dao;
import org.example.manytomany.bean.RoleEz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleDao extends JpaRepository<RoleEz,String>{
    RoleEz findByRolename(String rolename);
}
