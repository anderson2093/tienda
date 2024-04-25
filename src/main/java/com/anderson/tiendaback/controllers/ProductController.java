package com.anderson.tiendaback.controllers;

import java.net.URI;
import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;


import com.anderson.tiendaback.dto.ProductDTO;
import com.anderson.tiendaback.exception.ModelNotFoundException;
import com.anderson.tiendaback.models.Product;
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


import com.anderson.tiendaback.services.ProductService;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = productService.findAll().stream().map(p -> mapper.map(p, ProductDTO.class)).collect(Collectors.toList());

		return new ResponseEntity<>(list, OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable("id") UUID id) {
		Product obj = productService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		} else {
			return new ResponseEntity<>(mapper.map(obj, ProductDTO.class), OK);
		}
	}


	@PostMapping
	public ResponseEntity<Void> save(@RequestBody ProductDTO dto){
		Product obj = productService.save(mapper.map(dto, Product.class));
		//localhost:8080/product/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getProductId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody ProductDTO dto) {
		Product obj = productService.update(mapper.map(dto, Product.class));
		return new ResponseEntity<>(obj, OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
		Product obj = productService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		productService.delete(id);
		return new ResponseEntity<>(NO_CONTENT);
	}
	
	
}
