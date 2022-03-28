package com.listBuilder.front.controller.units.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "UnitModel", description = "The unit infos")
public class UnitsDTO {

	@Schema(description = "unit's Id", required = true)
	private Long id;

	@Schema(description = "unit's name")
	private String name;

	@Schema(description = "unit's bookId")
	private Long bookId;

	@Schema(description = "unit's unitType")
	private String unitType;

	@Schema(description = "unit's unitCategory")
	private String unitCategory;

	@Schema(description = "unit's namedUnique")
	private Boolean namedUnique;

	@Schema(description = "unit's defaultMount")
	private Boolean defaultMount;

	@Schema(description = "unit's movement")
	private Integer movement;

	@Schema(description = "unit's closeCombatSkills")
	private Integer closeCombatSkills;
	
	@Schema(description = "unit's shootingSkills")
	private Integer shootingSkills;

	@Schema(description = "unit's strengh")
	private Integer strengh;

	@Schema(description = "unit's toughness")
	private Integer toughness;

	@Schema(description = "unit's wounds")
	private Integer wounds;

	@Schema(description = "unit's initiative")
	private Integer initiative;

	@Schema(description = "unit's attacks")
	private Integer attacks;

	@Schema(description = "unit's leadership")
	private Integer leadership;

	@Schema(description = "unit's baseArmor")
	private Integer baseArmor;

	@Schema(description = "unit's baseInvul")
	private Integer baseInvul;

	@Schema(description = "unit's magicLvl")
	private Integer magicLvl;

	@Schema(description = "unit's basecost")
	private Integer baseCost;
}
