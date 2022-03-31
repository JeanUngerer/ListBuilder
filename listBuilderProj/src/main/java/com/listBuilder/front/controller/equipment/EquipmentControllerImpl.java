package com.listBuilder.front.controller.equipment;


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

import com.listBuilder.back.service.equipment.EquipmentService;
import com.listBuilder.back.service.equipment.domain.Equipment;
import com.listBuilder.front.controller.equipment.adapter.EquipmentAdapter;
import com.listBuilder.front.controller.equipment.dto.EquipmentDTO;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class EquipmentControllerImpl implements EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@Override
	@GetMapping("/equipment/{id}")
	public ResponseEntity<EquipmentDTO> getEquipmentById(@PathVariable Long id) throws Exception {
		Equipment equipment = equipmentService.getEquipmentById(id);
		return new ResponseEntity<>(EquipmentAdapter.adaptToDto(equipment), HttpStatus.OK);
	}

	@Override
	@GetMapping("/equipment")
	public ResponseEntity<List<EquipmentDTO>> getAllEquipment() throws Exception {
		List<Equipment> units = equipmentService.getAllEquipment();
		return new ResponseEntity<>(EquipmentAdapter.adaptToDto(units), HttpStatus.OK);
	}

	@Override
	@PostMapping(path = "/equipment", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> createEquipment(@RequestBody EquipmentDTO dto) {
		String equipment = equipmentService.createEquipment(
				dto.getId(),
				dto.getName(),
				dto.getBookId(),
				dto.getType(),
				dto.getEffectStats());

		return ResponseEntity.ok().body(equipment);
	}

	@Override
	@PutMapping(path = "/equipment/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<EquipmentDTO> updateEquipment(@PathVariable Long id, @RequestBody EquipmentDTO dto) {
		Equipment equipment = equipmentService.updateEquipment(id, dto.getId(),
				dto.getId(),
				dto.getName(),
				dto.getBookId(),
				dto.getType(),
				dto.getEffectStats());
		
		return ResponseEntity.ok().body(EquipmentAdapter.adaptToDto(equipment));
	}

	@Override
	@DeleteMapping("/equipment/{id}")
	public ResponseEntity<String> deleteEquipment(@PathVariable Long id) {
		equipmentService.deleteEquipment(id);
		return new ResponseEntity<>("The equipment " + id + " has been deleted", HttpStatus.OK);
	}

}
