package org.example.architcturejee1.dao;

import org.example.architcturejee1.bean.Patinet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PatientDao extends JpaRepository<Patinet, Long> {

}
