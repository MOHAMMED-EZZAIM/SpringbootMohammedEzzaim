package org.example.manytomany1.dao;
import org.example.manytomany1.bean.RoleEz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleDao extends JpaRepository<RoleEz,Long>{
    RoleEz findByRolename(String rolename);
}
