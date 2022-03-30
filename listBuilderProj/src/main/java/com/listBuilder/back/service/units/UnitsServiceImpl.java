package com.listBuilder.back.service.units;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.listBuilder.back.buisness.error.ListBuilderEventCode;
import com.listBuilder.back.buisness.error.ListBuilderException;

import com.listBuilder.back.db.units.entity.UnitsEntity;
import com.listBuilder.back.db.units.repository.UnitsRepository;
import com.listBuilder.back.service.units.adapter.UnitsBackAdapter;
import com.listBuilder.back.service.units.domain.Units;
import lombok.Data;

@Data
@Service
public class UnitsServiceImpl implements UnitsService {
	private final UnitsRepository unitsRepository;
	private final PlatformTransactionManager transactionManager;
	
	@Autowired
	public UnitsServiceImpl(UnitsRepository unitsRepository, PlatformTransactionManager transactionManager)
	{
		this.unitsRepository = unitsRepository;
		this.transactionManager = transactionManager;
	}
	
	
	@Override
	public Units getUnitsById(long id)
	{
		validateId(id);
		
		UnitsEntity units = unitsRepository.findById(id).orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "no units found"));
		return UnitsBackAdapter.adaptToBusinessObject(units);
		
	}
	
	@Override
	public List<Units> getAllUnits() throws ListBuilderException {
		List<UnitsEntity> units = unitsRepository.findAll();
		if (units == null || units.isEmpty()) {
			throw new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "No Units found in DB");
		}
		return UnitsBackAdapter.adaptToBusinessObject(units);
	}
	

	private void validateId(Long id) {
		if (id == null) {
			throw new ListBuilderException(ListBuilderEventCode.INVALID_DATA, "no units id defined");
		}
	}
	
	@Override
	public void deleteUnits(Long id) {
		unitsRepository.deleteById(id);
	}
	
	@Override
	public String createUnits(Long id, String name, Long bookId, String unitType, String unitCategory, Boolean namedUnique,
			Boolean defaultMount, Integer movement, Integer closeCombatSkills, Integer shootingSkills, Integer strengh,
			Integer toughness, Integer wounds, Integer initiative, Integer attacks, Integer leadership,
			Integer baseArmor, Integer baseInvul, Integer magicLvl, Integer baseCost) {
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		UnitsEntity entity = new UnitsEntity();
		return transactionTemplate.execute(new TransactionCallback<String>() {
			@Override
			public String doInTransaction(TransactionStatus transactionStatus) {
				try {
					entity.setId(id);
					entity.setName(name);
					entity.setBookId(bookId);
					entity.setUnitType(unitType);
					entity.setUnitCategory(unitCategory);
					entity.setNamedUnique(namedUnique);
					entity.setDefaultMount(defaultMount);
					entity.setMovement(movement);
					entity.setCloseCombatSkills(closeCombatSkills);
					entity.setShootingSkills(shootingSkills);
					entity.setStrengh(strengh);
					entity.setToughness(toughness);
					entity.setWounds(wounds);
					entity.setInitiative(initiative);
					entity.setAttacks(attacks);
					entity.setLeadership(leadership);
					entity.setBaseArmor(baseArmor);
					entity.setBaseInvul(baseInvul);
					entity.setMagicLvl(magicLvl);
					entity.setBaseCost(baseCost);
					
					UnitsEntity result = unitsRepository.save(entity);
					return result.getId().toString();
				} catch (Throwable t) {
					transactionStatus.setRollbackOnly();
					throw new RuntimeException("Error during the recording of the unit in database", t);
				}
			}
		});
	}
	
	@Override
	public Units updateUnits(Long id, Long id2, Long id3, String name, Long bookId, String unitType, String unitCategory,
			Boolean namedUnique, Boolean defaultMount, Integer movement, Integer closeCombatSkills,
			Integer shootingSkills, Integer strengh, Integer toughness, Integer wounds, Integer initiative,
			Integer attacks, Integer leadership, Integer baseArmor, Integer baseInvul, Integer magicLvl,
			Integer baseCost) {
		
		UnitsEntity entity = unitsRepository.findById(id)
				.orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "unit not found"));
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		
		return transactionTemplate.execute(new TransactionCallback<Units>() {
			@Override
			public Units doInTransaction(TransactionStatus transactionStatus) {
				try {
					entity.setId(id != null ? id : entity.getId());
					entity.setName(name != null ? name : entity.getName());
					entity.setBookId(bookId != null ? bookId : entity.getBookId());
					entity.setUnitType(unitType != null ? unitType : entity.getUnitType());
					entity.setUnitCategory(unitCategory != null ? unitCategory : entity.getUnitCategory());
					entity.setNamedUnique(namedUnique != null ? namedUnique : entity.getNamedUnique());
					entity.setDefaultMount(defaultMount != null ? defaultMount : entity.getDefaultMount());
					entity.setMovement(movement != null ? movement : entity.getMovement());
					entity.setCloseCombatSkills(closeCombatSkills != null ? closeCombatSkills : entity.getCloseCombatSkills());
					entity.setShootingSkills(shootingSkills != null ? shootingSkills : entity.getShootingSkills());
					entity.setStrengh(strengh != null ? strengh : entity.getStrengh());
					entity.setToughness(toughness != null ? toughness : entity.getToughness());
					entity.setWounds(wounds != null ? wounds : entity.getWounds());
					entity.setInitiative(initiative != null ? initiative : entity.getInitiative());
					entity.setAttacks(attacks != null ? attacks : entity.getAttacks());
					entity.setLeadership(leadership != null ? leadership : entity.getLeadership());
					entity.setBaseArmor(baseArmor != null ? baseArmor : entity.getBaseArmor());
					entity.setBaseInvul(baseInvul != null ? baseInvul : entity.getBaseInvul());
					entity.setMagicLvl(magicLvl != null ? magicLvl : entity.getMagicLvl());
					entity.setBaseCost(baseCost != null ? baseCost : entity.getBaseCost());
					
					UnitsEntity result = unitsRepository.save(entity);
					return UnitsBackAdapter.adaptToBusinessObject(result);
				} catch (Throwable t) {
					transactionStatus.setRollbackOnly();
					throw new RuntimeException("Error during the update of the unit in database", t);
				}
			}
		});
	}

	
	
	
	
	
}
