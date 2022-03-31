package com.listBuilder.front.controller.equipment.adapter;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.listBuilder.back.service.equipment.domain.Equipment;
import com.listBuilder.front.controller.equipment.dto.EquipmentDTO;

public class EquipmentAdapter {

	public static EquipmentDTO adaptToDto(Equipment equipment) {
		if (equipment == null) {
			return null;
		}
		EquipmentDTO dto = new EquipmentDTO();
		dto.setId(equipment.getId());
		dto.setName(equipment.getName());
		dto.setBookId(equipment.getBookId());
		dto.setType(equipment.getType());
		dto.setEffectStats(equipment.getEffectStats());
		
		return dto;
	}

	public static List<EquipmentDTO> adaptToDto(List<Equipment> units) {
		if (units == null) {
			return new ArrayList<>();
		}
		return units.stream().map(EquipmentAdapter::adaptToDto).collect(Collectors.toList());
	}

}