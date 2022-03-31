package com.listBuilder.back.service.equipment.adapter;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.listBuilder.back.db.equipment.entity.EquipmentEntity;

import com.listBuilder.back.service.equipment.domain.Equipment;

public class EquipmentBackAdapter {

	public static Equipment adaptToBusinessObject(EquipmentEntity entity) {
		if (entity == null) {
			return null;
		}
		Equipment equipment = new Equipment();
		
		equipment.setId(entity.getId());
		equipment.setName(entity.getName());
		equipment.setBookId(entity.getBookId());
		equipment.setType(entity.getType());
		equipment.setEffectStats(entity.getEffectStats());


		return equipment;
	}

	public static List<Equipment> adaptToBusinessObject(List<EquipmentEntity> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(EquipmentBackAdapter::adaptToBusinessObject).collect(Collectors.toList());
	}
}