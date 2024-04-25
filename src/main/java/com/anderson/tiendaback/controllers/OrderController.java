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

import com.anderson.tiendaback.exception.ResourceNotFoundException;
import com.anderson.tiendaback.models.Order;
import com.anderson.tiendaback.services.OrderService;
import com.anderson.tiendaback.dto.OrderDTO;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping(params = {"page","size","sortDir","sort"})
	public ResponseEntity<List<Order>> getOrder(@RequestParam("page")int page,@RequestParam("size")int size,@RequestParam("sortDir")String sortDir,@RequestParam("sort")String sort){
		List<Order> orders = orderService.getAll(page, size, sortDir, sort).stream().map(order->{
			return order;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order>getOrderById(@PathVariable UUID id){
		Optional<Order> order = orderService.getOne(id);
		if(!order.isPresent()) {
			new ResourceNotFoundException("Id "+id+ "is not existed");
		}
		return ResponseEntity.ok(order.get());
	}
	
	@PostMapping
	public ResponseEntity<Order>createOrder(@RequestBody OrderDTO orderViewModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Order order = this.mapper.convertToOrderEntity(orderViewModel);
		return new ResponseEntity<>(orderService.insertOrUpdate(order),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order>updateOrder(@PathVariable UUID id,@RequestBody OrderDTO orderViewModel){
		if(!orderService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Order not found with id " + id);
		}
		Order order = this.mapper.convertToOrderEntity(orderViewModel);
		return  ResponseEntity.ok(orderService.insertOrUpdate(order));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteOrder(@PathVariable UUID id){
		return orderService.getOne(id).map(fabric -> {
			orderService.delete(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
	}
}
