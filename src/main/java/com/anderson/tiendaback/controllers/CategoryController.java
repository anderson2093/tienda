package com.anderson.tiendaback.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.anderson.tiendaback.exception.ModelNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.anderson.tiendaback.models.Category;
import com.anderson.tiendaback.services.CategoryService;
import com.anderson.tiendaback.dto.CategoryDTO;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = categoryService.findAll().stream().map(p -> mapper.map(p, CategoryDTO.class)).collect(Collectors.toList());

		return new ResponseEntity<>(list, OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable("id") UUID id) {
		Category obj = categoryService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		} else {
			return new ResponseEntity<>(mapper.map(obj, CategoryDTO.class), OK);
		}
	}


	@PostMapping
	public ResponseEntity<Void> save(@RequestBody CategoryDTO dto){
		Category obj = categoryService.save(mapper.map(dto, Category.class));
		//localhost:8080/category/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCategoryId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Category> update(@RequestBody CategoryDTO dto) {
		Category obj = categoryService.update(mapper.map(dto, Category.class));
		return new ResponseEntity<>(obj, OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
		Category obj = categoryService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		categoryService.delete(id);
		return new ResponseEntity<>(NO_CONTENT);
	}
}
