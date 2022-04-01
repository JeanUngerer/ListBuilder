package com.listBuilder.back.service.allBooks.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllBooks {
	
	private Long id;
	
	private String name;
	
	private String version;

	private String linkPath;
}