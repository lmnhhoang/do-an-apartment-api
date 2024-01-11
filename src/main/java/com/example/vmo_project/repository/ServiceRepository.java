package com.example.vmo_project.repository;

import com.example.vmo_project.entity.Service;
import java.util.Arrays;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

  List<Service> findAllByApartmentId(Long apartmentId);
}
