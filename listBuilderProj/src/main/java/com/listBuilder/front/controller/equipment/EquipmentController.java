package com.listBuilder.front.controller.equipment;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.listBuilder.front.controller.equipment.dto.EquipmentDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface EquipmentController {

	@Operation(summary = "returns equipment infos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful operation"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No equipment found for this id"),
			// 500 = SERVER ERROR
			@ApiResponse(responseCode = "500", description = "server error") })
	ResponseEntity<EquipmentDTO> getEquipmentById(@Parameter(description = "The id of the equipment", example = "1") Long id)
			throws Exception;

	@Operation(summary = "returns all equipment")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Successful operation"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No equipment found in DB"),
			// 500 = SERVER ERROR
			@ApiResponse(responseCode = "500", description = "server error") })
	ResponseEntity<List<EquipmentDTO>> getAllEquipment() throws Exception;

	@Operation(summary = "Creates and saves an equipment")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The equipment was successfully created"),
			@ApiResponse(responseCode = "204", description = "No content"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "409", description = "An equipment still exists for this infos") })
	public ResponseEntity<String> createEquipment(
			@Parameter(description = "The object that contains the variables to save an equipment", required = true) EquipmentDTO equipment);

	@Operation(summary = "Updates an equipment")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The equipment was successfully updated"),
			@ApiResponse(responseCode = "204", description = "No content"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "404", description = "No equipment found for this id") })
	public ResponseEntity<EquipmentDTO> updateEquipment(
			@Parameter(description = "The id of the equipment to update", required = true) Long id,
			@Parameter(description = "The object that contains the variables to save an equipment", required = true) EquipmentDTO equipment);

	@Operation(summary = "Deletes an equipment")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "The equipment version was successfully deleted"),
			// 409 = CONFLICT
			@ApiResponse(responseCode = "409", description = "No equipment exists for this id") })
	ResponseEntity<String> deleteEquipment(@Parameter(description = "The equipment id to delete", required = true) Long id);

}