package com.listBuilder.back.service.units.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Units {
	
	private Long id;
	
	private String name;
	
	private Long bookId;

	private String unitType;

	private String unitCategory;

	private Boolean namedUnique;

	private Boolean defaultMount;

	private Integer movement;

	private Integer closeCombatSkills;

	private Integer shootingSkills;

	private Integer strengh;
	
	private Integer toughness;

	private Integer wounds;

	private Integer initiative;

	private Integer attacks;

	private Integer leadership;

	private Integer baseArmor;

	private Integer baseInvul;

	private Integer magicLvl;

	private Integer baseCost;
	
	
}
