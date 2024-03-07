package org.example.bankapplicationbackend.dao;

import org.example.bankapplicationbackend.bean.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountDao extends JpaRepository<BankAccount,String> {



}
