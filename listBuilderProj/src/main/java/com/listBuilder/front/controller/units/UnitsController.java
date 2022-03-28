package com.listBuilder.front.controller.units;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.listBuilder.front.controller.units.dto.UnitsDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UnitsController {

	@Operation(summary = "returns units infos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful operation"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No machine found for this id"),
			// 500 = SERVER ERROR
			@ApiResponse(responseCode = "500", description = "server error") })
	ResponseEntity<UnitsDTO> getUnitsById(@Parameter(description = "The id of the machine", example = "1") Long id)
			throws Exception;

	@Operation(summary = "returns all units")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful operation"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No machine found in DB"),
			// 500 = SERVER ERROR
			@ApiResponse(responseCode = "500", description = "server error") })
	ResponseEntity<List<UnitsDTO>> getAllUnits() throws Exception;

	@Operation(summary = "Creates and saves a units")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The machine was successfully created"),
			@ApiResponse(responseCode = "204", description = "No content"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "409", description = "A machine still exists for this infos") })
	public ResponseEntity<String> createUnits(
			@Parameter(description = "The object that contains the variables to save a machine", required = true) UnitsDTO unit);

	@Operation(summary = "Updates a units")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The machine was successfully updated"),
			@ApiResponse(responseCode = "204", description = "No content"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No machine found for this id") })
	public ResponseEntity<UnitsDTO> updateUnits(
			@Parameter(description = "The id of the machine to update", required = true) Long id,
			@Parameter(description = "The object that contains the variables to save a machine", required = true) UnitsDTO machine);

	@Operation(summary = "Deletes a units")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The machine version was successfully deleted"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "409", description = "No machine exists for this id") })
	ResponseEntity<String> deleteUnits(@Parameter(description = "The machine id to delete", required = true) Long id);

}