package org.example.bankapplicationbackend.dao;

import org.example.bankapplicationbackend.bean.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationDao extends JpaRepository<AccountOperation, Long> {
     List<AccountOperation> findByBankAccountId(String accountId);
     Page<AccountOperation> findByBankAccountId(String bankAccountId, Pageable pageable);
}
