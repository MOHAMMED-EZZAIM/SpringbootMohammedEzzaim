package org.example.bankapplicationbackend.dao;

import org.example.bankapplicationbackend.bean.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationDao extends JpaRepository<AccountOperation,Long> {

}
