package com.listBuilder.front.controller.allBooks.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.listBuilder.back.service.allBooks.domain.AllBooks;
import com.listBuilder.front.controller.allBooks.dto.AllBooksDTO;

public class AllBooksAdapter {

	public static AllBooksDTO adaptToDto(AllBooks allBooks) {
		if (allBooks == null) {
			return null;
		}
		AllBooksDTO dto = new AllBooksDTO();
		dto.setId(allBooks.getId());
		dto.setName(allBooks.getName());
		dto.setVersion(allBooks.getVersion());
		dto.setLinkPath(allBooks.getLinkPath());
		
		return dto;
	}

	public static List<AllBooksDTO> adaptToDto(List<AllBooks> allBooks) {
		if (allBooks == null) {
			return new ArrayList<>();
		}
		return allBooks.stream().map(AllBooksAdapter::adaptToDto).collect(Collectors.toList());
	}

}