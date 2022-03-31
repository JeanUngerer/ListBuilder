package com.listBuilder.back.service.equipment.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equipment {
	
	private Long id;
	
	private String name;
	
	private Long bookId;

	private String type;

	private String effectStats;
}