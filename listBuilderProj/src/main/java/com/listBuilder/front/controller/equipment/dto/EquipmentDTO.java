package com.listBuilder.front.controller.equipment.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "EquipmentModel", description = "The equipment infos")
public class EquipmentDTO {

	@Schema(description = "equipment's Id", required = true)
	private Long id;

	@Schema(description = "equipment's name")
	private String name;

	@Schema(description = "equipment's bookId")
	private Long bookId;

	@Schema(description = "equipment's unitType")
	private String type;

	@Schema(description = "equipment's unitCategory")
	private String effectStats;

}
