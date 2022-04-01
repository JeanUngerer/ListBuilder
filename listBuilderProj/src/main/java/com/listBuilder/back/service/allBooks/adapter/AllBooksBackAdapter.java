package com.listBuilder.back.service.allBooks.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.listBuilder.back.db.allBooks.entity.AllBooksEntity;

import com.listBuilder.back.service.allBooks.domain.AllBooks;

public class AllBooksBackAdapter {

	public static AllBooks adaptToBusinessObject(AllBooksEntity entity) {
		if (entity == null) {
			return null;
		}
		AllBooks allBooks = new AllBooks();
		
		allBooks.setId(entity.getId());
		allBooks.setName(entity.getName());
		allBooks.setVersion(entity.getVersion());
		allBooks.setLinkPath(entity.getLinkPath());

		return allBooks;
	}

	public static List<AllBooks> adaptToBusinessObject(List<AllBooksEntity> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(AllBooksBackAdapter::adaptToBusinessObject).collect(Collectors.toList());
	}
}