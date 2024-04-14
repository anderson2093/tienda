package com.anderson.tiendaback.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.tiendaback.Mapper;
import com.anderson.tiendaback.exception.ResourceNotFoundException;
import com.anderson.tiendaback.models.Category;
import com.anderson.tiendaback.services.CategoryService;
import com.anderson.tiendaback.viewModels.CategoryViewModel;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping(params = {"page","size","sortDir","sort"})
	public ResponseEntity<List<Category>> getCategory(@RequestParam("page")int page,@RequestParam("size")int size,@RequestParam("sortDir")String sortDir,@RequestParam("sort")String sort){
		List<Category> categorys = categoryService.getAll(page, size, sortDir, sort).stream().map(category->{
			return category;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Category>>(categorys,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category>getCategoryById(@PathVariable UUID id){
		Optional<Category> category = categoryService.getOne(id);
		if(!category.isPresent()) {
			new ResourceNotFoundException("Id "+id+ "is not existed");
		}
		return ResponseEntity.ok(category.get());
	}
	
	@PostMapping
	public ResponseEntity<Category>createFabric(@RequestBody CategoryViewModel categoryViewModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Category category = this.mapper.convertToCategoryEntity(categoryViewModel);
		return new ResponseEntity<>(categoryService.insertOrUpdate(category),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category>updateFabric(@PathVariable UUID id,@RequestBody CategoryViewModel categoryViewModel){
		if(!categoryService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Category not found with id " + id);
		}
		Category category = this.mapper.convertToCategoryEntity(categoryViewModel);
		return  ResponseEntity.ok(categoryService.insertOrUpdate(category));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteCategory(@PathVariable UUID id){
		return categoryService.getOne(id).map(fabric -> {
			categoryService.delete(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
	}
}
