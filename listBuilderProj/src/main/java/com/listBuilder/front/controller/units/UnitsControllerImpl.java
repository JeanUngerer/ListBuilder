package com.listBuilder.front.controller.units;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.listBuilder.back.service.units.UnitsService;
import com.listBuilder.back.service.units.domain.Units;
import com.listBuilder.front.controller.units.adapter.UnitsAdapter;
import com.listBuilder.front.controller.units.dto.UnitsDTO;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class UnitsControllerImpl implements UnitsController {

	@Autowired
	private UnitsService unitsService;

	@Override
	@GetMapping("/units/{id}")
	public ResponseEntity<UnitsDTO> getUnitsById(@PathVariable Long id) throws Exception {
		Units unit = unitsService.getUnitsById(id);
		return new ResponseEntity<>(UnitsAdapter.adaptToDto(unit), HttpStatus.OK);
	}

	@Override
	@GetMapping("/units")
	public ResponseEntity<List<UnitsDTO>> getAllUnits() throws Exception {
		List<Units> units = unitsService.getAllUnits();
		return new ResponseEntity<>(UnitsAdapter.adaptToDto(units), HttpStatus.OK);
	}

	@Override
	@PostMapping(path = "/unit", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> createUnits(@RequestBody UnitsDTO dto) {
		String unit = unitsService.createUnits(
				dto.getId(),
				dto.getName(),
				dto.getBookId(),
				dto.getUnitType(),
				dto.getUnitCategory(),
				dto.getNamedUnique(),
				dto.getDefaultMount(),
				dto.getMovement(),
				dto.getCloseCombatSkills(),
				dto.getShootingSkills(),
				dto.getStrengh(),
				dto.getToughness(),
				dto.getWounds(),
				dto.getInitiative(),
				dto.getAttacks(),
				dto.getLeadership(),
				dto.getBaseArmor(),
				dto.getBaseInvul(),
				dto.getMagicLvl(),
				dto.getBaseCost());
			
		return ResponseEntity.ok().body(unit);
	}

	@Override
	@PutMapping(path = "/unit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<UnitsDTO> updateUnits(@PathVariable Long id, @RequestBody UnitsDTO dto) {
		Units unit = unitsService.updateUnits(id, dto.getId(),
				dto.getId(),
				dto.getName(),
				dto.getBookId(),
				dto.getUnitType(),
				dto.getUnitCategory(),
				dto.getNamedUnique(),
				dto.getDefaultMount(),
				dto.getMovement(),
				dto.getCloseCombatSkills(),
				dto.getShootingSkills(),
				dto.getStrengh(),
				dto.getToughness(),
				dto.getWounds(),
				dto.getInitiative(),
				dto.getAttacks(),
				dto.getLeadership(),
				dto.getBaseArmor(),
	 			dto.getBaseInvul(),
				dto.getMagicLvl(),
				dto.getBaseCost());
		
		return ResponseEntity.ok().body(UnitsAdapter.adaptToDto(unit));
	}

	@Override
	@DeleteMapping("/unit/{id}")
	public ResponseEntity<String> deleteUnits(@PathVariable Long id) {
		unitsService.deleteUnits(id);
		return new ResponseEntity<>("The unit " + id + " has been deleted", HttpStatus.OK);
	}

}
