package com.listBuilder.back.db.allBooks.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.listBuilder.back.db.allBooks.entity.AllBooksEntity;

public interface AllBooksRepository extends JpaRepository<AllBooksEntity,Long> {
	
}