package com.example.thuchanh3_lmh.repository;

import com.example.thuchanh3_lmh.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}

