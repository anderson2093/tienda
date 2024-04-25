package com.anderson.tiendaback.controllers;


import java.net.URI;
import java.util.List;
import java.util.UUID;


import com.anderson.tiendaback.dto.OrderListProductDTO;
import com.anderson.tiendaback.exception.ModelNotFoundException;
import com.anderson.tiendaback.models.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.anderson.tiendaback.models.Order;
import com.anderson.tiendaback.services.OrderService;
import com.anderson.tiendaback.dto.OrderDTO;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ModelMapper mapper;

	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable("id") UUID id) {
		Order obj = orderService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		} else {
			return new ResponseEntity<>(mapper.map(obj, OrderDTO.class), OK);
		}
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody OrderListProductDTO dto) {
		Order cons = mapper.map(dto.getOrder(), Order.class);
		List<Product> products = mapper.map(dto.getLstProduct(), new TypeToken<List<Product>>() {
		}.getType());

		Order obj = orderService.saveTransactional(cons, products);
		//localhost:8080/consults/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getOrderId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Order> update(@RequestBody OrderDTO dto) {
		Order obj = orderService.update(mapper.map(dto, Order.class));
		return new ResponseEntity<>(obj, OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
		Order obj = orderService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		orderService.delete(id);
		return new ResponseEntity<>(NO_CONTENT);
	}
}
