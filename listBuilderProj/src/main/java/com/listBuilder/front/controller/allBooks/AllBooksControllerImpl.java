package com.listBuilder.front.controller.allBooks;

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

import com.listBuilder.back.service.allBooks.AllBooksService;
import com.listBuilder.back.service.allBooks.domain.AllBooks;
import com.listBuilder.front.controller.allBooks.adapter.AllBooksAdapter;
import com.listBuilder.front.controller.allBooks.dto.AllBooksDTO;

@RestController
@RequestMapping("${spring.data.rest.base-path}")
public class AllBooksControllerImpl implements AllBooksController {

	@Autowired
	private AllBooksService allBooksService;

	@Override
	@GetMapping("/allBooks/{id}")
	public ResponseEntity<AllBooksDTO> getAllBooksById(@PathVariable Long id) throws Exception {
		AllBooks allBooks = allBooksService.getAllBooksById(id);
		return new ResponseEntity<>(AllBooksAdapter.adaptToDto(allBooks), HttpStatus.OK);
	}

	@Override
	@GetMapping("/allBooks")
	public ResponseEntity<List<AllBooksDTO>> getAllAllBooks() throws Exception {
		List<AllBooks> units = allBooksService.getAllAllBooks();
		return new ResponseEntity<>(AllBooksAdapter.adaptToDto(units), HttpStatus.OK);
	}

	@Override
	@PostMapping(path = "/allBooks", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<String> createAllBooks(@RequestBody AllBooksDTO dto) {
		String allBooks = allBooksService.createAllBooks(
				dto.getId(),
				dto.getName(),
				dto.getVersion(),
				dto.getLinkPath());

		return ResponseEntity.ok().body(allBooks);
	}

	@Override
	@PutMapping(path = "/allBooks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<AllBooksDTO> updateAllBooks(@PathVariable Long id, @RequestBody AllBooksDTO dto) {
		AllBooks allBooks = allBooksService.updateAllBooks(id, dto.getId(),
				dto.getId(),
				dto.getName(),
				dto.getVersion(),
				dto.getLinkPath());
		
		return ResponseEntity.ok().body(AllBooksAdapter.adaptToDto(allBooks));
	}

	@Override
	@DeleteMapping("/allBooks/{id}")
	public ResponseEntity<String> deleteAllBooks(@PathVariable Long id) {
		allBooksService.deleteAllBooks(id);
		return new ResponseEntity<>("The allBooks " + id + " has been deleted", HttpStatus.OK);
	}

}