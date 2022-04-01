package com.listBuilder.front.controller.allBooks;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.listBuilder.front.controller.allBooks.dto.AllBooksDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface AllBooksController {

	@Operation(summary = "returns allBooks infos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful operation"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No allBooks found for this id"),
			// 500 = SERVER ERROR
			@ApiResponse(responseCode = "500", description = "server error") })
	ResponseEntity<AllBooksDTO> getAllBooksById(@Parameter(description = "The id of the allBooks", example = "1") Long id)
			throws Exception;

	@Operation(summary = "returns all allBooks")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful operation"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No allBooks found in DB"),
			// 500 = SERVER ERROR
			@ApiResponse(responseCode = "500", description = "server error") })
	ResponseEntity<List<AllBooksDTO>> getAllAllBooks() throws Exception;

	@Operation(summary = "Creates and saves an allBooks")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The allBooks was successfully created"),
			@ApiResponse(responseCode = "204", description = "No content"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "409", description = "An allBooks still exists for this infos") })
	public ResponseEntity<String> createAllBooks(
			@Parameter(description = "The object that contains the variables to save an allBooks", required = true) AllBooksDTO allBooks);

	@Operation(summary = "Updates an allBooks")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The allBooks was successfully updated"),
			@ApiResponse(responseCode = "204", description = "No content"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No allBooks found for this id") })
	public ResponseEntity<AllBooksDTO> updateAllBooks(
			@Parameter(description = "The id of the allBooks to update", required = true) Long id,
			@Parameter(description = "The object that contains the variables to save an allBooks", required = true) AllBooksDTO allBooks);

	@Operation(summary = "Deletes an allBooks")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The allBooks version was successfully deleted"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "409", description = "No allBooks exists for this id") })
	ResponseEntity<String> deleteAllBooks(@Parameter(description = "The allBooks id to delete", required = true) Long id);

}