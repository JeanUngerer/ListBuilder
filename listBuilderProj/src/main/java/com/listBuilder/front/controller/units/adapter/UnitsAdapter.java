package com.listBuilder.front.controller.units.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.listBuilder.back.service.units.domain.Units;
import com.listBuilder.front.controller.units.dto.UnitsDTO;

public class UnitsAdapter {

	public static UnitsDTO adaptToDto(Units unit) {
		if (unit == null) {
			return null;
		}
		UnitsDTO dto = new UnitsDTO();
		dto.setId(unit.getId());
		dto.setName(unit.getName());
		dto.setBookId(unit.getBookId());
		dto.setUnitType(unit.getUnitType());
		dto.setUnitCategory(unit.getUnitCategory());
		dto.setNamedUnique(unit.getNamedUnique());
		dto.setDefaultMount(unit.getDefaultMount());
		dto.setMovement(unit.getMovement());
		dto.setCloseCombatSkills(unit.getCloseCombatSkills());
		dto.setShootingSkills(unit.getShootingSkills());
		dto.setStrengh(unit.getStrengh());
		dto.setToughness(unit.getToughness());
		dto.setWounds(unit.getWounds());
		dto.setInitiative(unit.getInitiative());
		dto.setAttacks(unit.getAttacks());
		dto.setLeadership(unit.getLeadership());
		dto.setBaseArmor(unit.getBaseArmor());
		dto.setBaseInvul(unit.getBaseInvul());
		dto.setMagicLvl(unit.getMagicLvl());
		dto.setBaseCost(unit.getBaseCost());
		
		return dto;
	}

	public static List<UnitsDTO> adaptToDto(List<Units> units) {
		if (units == null) {
			return new ArrayList<>();
		}
		return units.stream().map(UnitsAdapter::adaptToDto).collect(Collectors.toList());
	}

}
