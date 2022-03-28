package com.listBuilder.back.service;

import org.springframework.web.bind.annotation.RestController;

import com.listBuilder.back.db.units.repository.UnitsRepository;
//import com.listBuilder.back.db.allBooks.repository.AllBooksRepository;
@RestController
public class RestApi {

	//private final AllBooksRepository repository;
	private final UnitsRepository repoUnits;

	RestApi( UnitsRepository repoUnits) {
		//this.repository = repository;
		this.repoUnits = repoUnits;
	}

//	// Aggregate root
//	// tag::get-aggregate-root[]
//	@GetMapping("/users")
//	List<UserEntity> allUsers() {
//		System.out.println("\t ****** all Users");
//		List<UserEntity> list = repository.findAll();
//		return list;
//	}
//	// end::get-aggregate-root[]
//
//	@GetMapping("/machines")
//	List<MachineEntity> allMachines() {
//		System.out.println("\t ****** all Machines");
//		List<MachineEntity> list = repoMachine.findAll();
//		return list;
//	}
//
//	// @PostMapping("/add")
//	@GetMapping("/add-user")
//	UserEntity addUser() {
//		UserEntity u = new UserEntity();
//		u.setName("New User");
//		repository.save(u);
//		return u;
//	}
//
//	@GetMapping("/add-machine")
//	MachineEntity addMachine() {
//		MachineEntity m = new MachineEntity();
//		m.setName("New Machine");
//		m.setStatus("Ok");
//		repoMachine.save(m);
//		return m;
//	}
//
//	// @PostMapping("/add")
//	@GetMapping("/update")
//	void updateUser() {
//		UserEntity u = repository.findUserByUserId(3);
//		u.setName("Old User");
//		repository.save(u);
//	}
//
//	// @DeleteMapping("/users/{id}")
//	@GetMapping("/users/{id}")
//	void deleteEmployee(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
}