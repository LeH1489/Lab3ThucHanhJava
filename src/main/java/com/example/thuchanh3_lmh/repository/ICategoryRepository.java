package com.example.thuchanh3_lmh.repository;

import com.example.thuchanh3_lmh.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
