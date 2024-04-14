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
import com.anderson.tiendaback.models.Product;
import com.anderson.tiendaback.services.ProductService;
import com.anderson.tiendaback.viewModels.ProductViewModel;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping(params = {"page","size","sortDir","sort"})
	public ResponseEntity<List<Product>> getProduct(@RequestParam("page")int page,@RequestParam("size")int size,@RequestParam("sortDir")String sortDir,@RequestParam("sort")String sort){
		List<Product> products = productService.getAll(page, size, sortDir, sort).stream().map(product->{
			return product;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product>getProductById(@PathVariable UUID id){
		Optional<Product> product = productService.getOne(id);
		if(!product.isPresent()) {
			new ResourceNotFoundException("Id "+id+ "is not existed");
		}
		return ResponseEntity.ok(product.get());
	}
	
	@PostMapping
	public ResponseEntity<Product>createProduct(@RequestBody ProductViewModel productViewModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Product product = this.mapper.convertToProductEntity(productViewModel);
		return new ResponseEntity<>(productService.insertOrUpdate(product),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product>updateProduct(@PathVariable UUID id,@RequestBody ProductViewModel productViewModel){
		if(!productService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Product not found with id " + id);
		}
		Product product = this.mapper.convertToProductEntity(productViewModel);
		return  ResponseEntity.ok(productService.insertOrUpdate(product));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteProduct(@PathVariable UUID id){
		return productService.getOne(id).map(fabric -> {
			productService.delete(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
	}
	
	
}
