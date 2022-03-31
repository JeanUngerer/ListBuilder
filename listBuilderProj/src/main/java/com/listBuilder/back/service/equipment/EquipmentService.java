package com.listBuilder.back.service.equipment;

import java.util.List;

import com.listBuilder.back.service.equipment.domain.Equipment;

public interface EquipmentService {


	Equipment getEquipmentById(long id);

	List<Equipment> getAllEquipment();

	String createEquipment(Long id, String name, Long bookId, String type, String effectStats);

	Equipment updateEquipment(Long id, Long id2, Long id3, String name, Long bookId, String type, String effectStats);

	void deleteEquipment(Long id);

	
}