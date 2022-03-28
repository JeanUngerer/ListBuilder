package com.listBuilder.back.service.units;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import com.listBuilder.back.service.units.adapter.UnitsBackAdapter;
import com.listBuilder.back.service.units.domain.Units;
import com.listBuilder.back.buisness.error.ListBuilderEventCode;
import com.listBuilder.back.buisness.error.ListBuilderException;
import com.listBuilder.back.db.units.entity.UnitsEntity;
import com.listBuilder.back.db.units.repository.UnitsRepository;
import lombok.Data;

@Data
@Service
public class UnitsServiceImpl {
	private final UnitsRepository unitsRepository;
	private final PlatformTransactionManager transactionManager;
	
	@Autowired
	public UnitsServiceImpl(UnitsRepository unitsRepository, PlatformTransactionManager transactionManager)
	{
		this.unitsRepository = unitsRepository;
		this.transactionManager = transactionManager;
	}
	
	
	
	public Units getUnitsById(long id)
	{
		validateId(id);
		
		UnitsEntity units = unitsRepository.findById(id).orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "no units found"));
		return UnitsBackAdapter.adaptToBusinessObject(units);
		
	}
	
	
	private void validateId(Long id) {
		if (id == null) {
			throw new ListBuilderException(ListBuilderEventCode.INVALID_DATA, "no units id defined");
		}
	}
}
