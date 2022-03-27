package com.listBuilder.back.db.units.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.listBuilder.back.db.units.entity.UnitsEntity;

public interface UnitsRepository extends JpaRepository<UnitsEntity,Long> {
	
}