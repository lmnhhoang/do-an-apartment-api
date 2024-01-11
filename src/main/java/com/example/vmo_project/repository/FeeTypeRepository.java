package com.example.vmo_project.repository;

import com.example.vmo_project.entity.FeeType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeTypeRepository extends JpaRepository<FeeType, Long> {

  List<FeeType> findByIdIn(List<Long> ids);
}
