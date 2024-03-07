package org.example.bankapplicationbackend.dao;

import org.example.bankapplicationbackend.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Long> {
}
