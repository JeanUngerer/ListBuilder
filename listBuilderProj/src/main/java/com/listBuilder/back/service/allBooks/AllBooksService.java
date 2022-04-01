package com.listBuilder.back.service.allBooks;


import java.util.List;

import com.listBuilder.back.service.allBooks.domain.AllBooks;

public interface AllBooksService {


	AllBooks getAllBooksById(long id);

	List<AllBooks> getAllAllBooks();

	String createAllBooks(Long id, String name, String version, String linkPath);

	AllBooks updateAllBooks(Long id, Long id2, Long id3, String name, String version, String linkPath);

	void deleteAllBooks(Long id);

	
}