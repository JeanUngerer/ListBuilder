package com.listBuilder.back.service.equipment;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.listBuilder.back.buisness.error.ListBuilderEventCode;
import com.listBuilder.back.buisness.error.ListBuilderException;

import com.listBuilder.back.db.equipment.entity.EquipmentEntity;
import com.listBuilder.back.db.equipment.repository.EquipmentRepository;
import com.listBuilder.back.service.equipment.adapter.EquipmentBackAdapter;
import com.listBuilder.back.service.equipment.domain.Equipment;
import lombok.Data;

@Data
@Service
public class EquipmentServiceImpl implements EquipmentService {
	private final EquipmentRepository equipmentRepository;
	private final PlatformTransactionManager transactionManager;
	
	@Autowired
	public EquipmentServiceImpl(EquipmentRepository equipmentRepository, PlatformTransactionManager transactionManager)
	{
		this.equipmentRepository = equipmentRepository;
		this.transactionManager = transactionManager;
	}
	
	
	@Override
	public Equipment getEquipmentById(long id)
	{
		validateId(id);
		
		EquipmentEntity equipment = equipmentRepository.findById(id).orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "no equipment found"));
		return EquipmentBackAdapter.adaptToBusinessObject(equipment);
		
	}
	
	@Override
	public List<Equipment> getAllEquipment() throws ListBuilderException {
		List<EquipmentEntity> equipment = equipmentRepository.findAll();
		if (equipment == null || equipment.isEmpty()) {
			throw new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "No equipment found in DB");
		}
		return EquipmentBackAdapter.adaptToBusinessObject(equipment);
	}
	

	private void validateId(Long id) {
		if (id == null) {
			throw new ListBuilderException(ListBuilderEventCode.INVALID_DATA, "no equipment id defined");
		}
	}
	
	@Override
	public void deleteEquipment(Long id) {
		equipmentRepository.deleteById(id);
	}
	
	@Override
	public String createEquipment(Long id, String name, Long bookId, String type, String effectStats) {
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		EquipmentEntity entity = new EquipmentEntity();
		return transactionTemplate.execute(new TransactionCallback<String>() {
			@Override
			public String doInTransaction(TransactionStatus transactionStatus) {
				try {
					entity.setId(id);
					entity.setName(name);
					entity.setBookId(bookId);
					entity.setType(type);
					entity.setEffectStats(effectStats);
					
					EquipmentEntity result = equipmentRepository.save(entity);
					return result.getId().toString();
				} catch (Throwable t) {
					transactionStatus.setRollbackOnly();
					throw new RuntimeException("Error during the recording of the equipment in database", t);
				}
			}
		});
	}
	
	@Override
	public Equipment updateEquipment(Long id, Long id2, Long id3, String name, Long bookId, String type, String effectStats) {
		
		EquipmentEntity entity = equipmentRepository.findById(id)
				.orElseThrow(() -> new ListBuilderException(ListBuilderEventCode.NOT_FOUND, "equipment not found"));
		
		TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
		
		return transactionTemplate.execute(new TransactionCallback<Equipment>() {
			@Override
			public Equipment doInTransaction(TransactionStatus transactionStatus) {
				try {
					entity.setId(id != null ? id : entity.getId());
					entity.setName(name != null ? name : entity.getName());
					entity.setBookId(bookId != null ? bookId : entity.getBookId());
					entity.setType(type != null ? type : entity.getType());
					entity.setEffectStats(effectStats != null ? effectStats : entity.getEffectStats());
					
					EquipmentEntity result = equipmentRepository.save(entity);
					return EquipmentBackAdapter.adaptToBusinessObject(result);
				} catch (Throwable t) {
					transactionStatus.setRollbackOnly();
					throw new RuntimeException("Error during the update of the equipment in database", t);
				}
			}
		});
	}

	
	
	
	
	
}