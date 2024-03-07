package org.example.architcturejee1.dao;

import org.example.architcturejee1.bean.Patinet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDao extends JpaRepository<Patinet,Long> {

}
