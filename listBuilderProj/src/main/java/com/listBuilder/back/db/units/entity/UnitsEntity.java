package com.listBuilder.back.db.units.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "units")
public class UnitsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private Integer name;

	@Column(name = "bookId")
	private Long bookId;

	@Column(name = "unitType")
	private String unitType;

	@Column(name = "unitCategory")
	private String unitCategory;

	@Column(name = "namedUnique")
	private Boolean namedUnique;

	@Column(name = "defaultMount")
	private Boolean defaultMount;

	@Column(name = "movement")
	private Integer movement;

	@Column(name = "closeCombatSkills")
	private Integer closeCombatSkills;

	@Column(name = "shootingSkills")
	private Integer shootingSkills;

	@Column(name = "strengh")
	private Integer strengh;
	
	@Column(name = "toughness")
	private Integer toughness;

	@Column(name = "wounds")
	private Integer wounds;

	@Column(name = "initiative")
	private Integer initiative;

	@Column(name = "attacks")
	private Integer attacks;

	@Column(name = "leadership")
	private Integer leadership;

	@Column(name = "baseArmor")
	private Integer baseArmor;

	@Column(name = "baseInvul")
	private Integer baseInvul;

	@Column(name = "magicLvl")
	private Integer magicLvl;

	@Column(name = "baseCost")
	private String baseCost;

}