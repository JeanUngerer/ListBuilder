package com.listBuilder.front.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.listBuilder.back.db.units.repository.UnitsRepository;

@Controller
public class WelcomeController {

	// private final UserRepository repository;
	// private final UnitsRepository repoUnits;
//	  private List<UnitsEntity> units;
//	  private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

	WelcomeController(UnitsRepository repoUnits) {
		// this.units = repoUnits.findAll();
	}

	// inject via application.properties
	@Value("${welcome.message}")
	private String welcome;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", "Liste des Unités");
		// model.addAttribute("units", units);

		return "welcome"; // view
	}

	// /hello?name=kotlin
	@GetMapping("/hello")
	public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name,
			Model model) {

		model.addAttribute("message", name);

		return "welcome"; // view
	}

}
