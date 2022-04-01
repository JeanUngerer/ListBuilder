package com.listBuilder.front.controller.allBooks.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "allBooksModel", description = "The allBooks infos")
public class AllBooksDTO {

	@Schema(description = "allBooks's Id", required = true)
	private Long id;

	@Schema(description = "allBooks's name")
	private String name;

	@Schema(description = "allBooks's version")
	private String version;

	@Schema(description = "allBooks's linkPath")
	private String linkPath;

}