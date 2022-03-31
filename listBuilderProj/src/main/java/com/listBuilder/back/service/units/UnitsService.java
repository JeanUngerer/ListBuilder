package com.listBuilder.back.service.units;

import java.util.List;

import com.listBuilder.back.service.units.domain.Units;

public interface UnitsService {


	public Units getUnitsById(long id) throws Exception;

	List<Units> getAllUnits() throws Exception;

	public String createUnits(Long id, String name, Long bookId, String unitType, String unitCategory, Boolean namedUnique,
			Boolean defaultMount, Integer movement, Integer closeCombatSkills, Integer shootingSkills, Integer strengh,
			Integer toughness, Integer wounds, Integer initiative, Integer attacks, Integer leadership,
			Integer baseArmor, Integer baseInvul, Integer magicLvl, Integer baseCost);

	public Units updateUnits(Long id, Long id2, Long id3, String name, Long bookId, String unitType, String unitCategory,
			Boolean namedUnique, Boolean defaultMount, Integer movement, Integer closeCombatSkills,
			Integer shootingSkills, Integer strengh, Integer toughness, Integer wounds, Integer initiative,
			Integer attacks, Integer leadership, Integer baseArmor, Integer baseInvul, Integer magicLvl,
			Integer baseCost);

	public void deleteUnits(Long id);

	
}
