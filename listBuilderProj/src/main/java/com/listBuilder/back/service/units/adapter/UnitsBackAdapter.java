package com.listBuilder.back.service.units.adapter;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.listBuilder.back.db.units.entity.UnitsEntity;
//import com.listBuilder.back.db.units.repository.UnitsRepository;
import com.listBuilder.back.service.units.domain.Units;

public class UnitsBackAdapter {

	public static Units adaptToBusinessObject(UnitsEntity entity) {
		if (entity == null) {
			return null;
		}
		Units units = new Units();
		
		units.setId(entity.getId());
		units.setName(entity.getName());
		units.setBookId(entity.getBookId());
		units.setUnitType(entity.getUnitType());
		units.setUnitCategory(entity.getUnitCategory());
		units.setNamedUnique(entity.getNamedUnique());
		units.setDefaultMount(entity.getDefaultMount());
		units.setMovement(entity.getMovement());
		units.setCloseCombatSkills(entity.getCloseCombatSkills());
		units.setShootingSkills(entity.getShootingSkills());
		units.setStrengh(entity.getStrengh());
		units.setToughness(entity.getToughness());
		units.setWounds(entity.getWounds());
		units.setInitiative(entity.getInitiative());
		units.setAttacks(entity.getAttacks());
		units.setLeadership(entity.getLeadership());
		units.setBaseArmor(entity.getBaseArmor());
		units.setBaseInvul(entity.getBaseInvul());
		units.setMagicLvl(entity.getMagicLvl());
		units.setBaseCost(entity.getBaseCost());

		return units;
	}

	public static List<Units> adaptToBusinessObject(List<UnitsEntity> entities) {
		if (entities == null) {
			return new ArrayList<>();
		}
		return entities.stream().map(UnitsBackAdapter::adaptToBusinessObject).collect(Collectors.toList());
	}
}
