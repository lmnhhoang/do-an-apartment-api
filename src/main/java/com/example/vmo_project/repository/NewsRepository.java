package com.example.vmo_project.repository;

import com.example.vmo_project.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

}
