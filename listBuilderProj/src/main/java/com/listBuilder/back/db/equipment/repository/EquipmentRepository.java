package com.listBuilder.back.db.equipment.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.listBuilder.back.db.equipment.entity.EquipmentEntity;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity,Long> {
	
}