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
import com.anderson.tiendaback.models.OrderDetail;
import com.anderson.tiendaback.services.OrderDetailService;
import com.anderson.tiendaback.viewModels.OrderDetailViewModel;

import jakarta.validation.ValidationException;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping(params = {"page","size","sortDir","sort"})
	public ResponseEntity<List<OrderDetail>> getOrderDetail(@RequestParam("page")int page,@RequestParam("size")int size,@RequestParam("sortDir")String sortDir,@RequestParam("sort")String sort){
		List<OrderDetail> orderDetails = orderDetailService.getAll(page, size, sortDir, sort).stream().map(orderDetail->{
			return orderDetail;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<OrderDetail>>(orderDetails,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDetail>getOrderDetailById(@PathVariable UUID id){
		Optional<OrderDetail> orderDetail = orderDetailService.getOne(id);
		if(!orderDetail.isPresent()) {
			new ResourceNotFoundException("Id "+id+ "is not existed");
		}
		return ResponseEntity.ok(orderDetail.get());
	}
	
	@PostMapping
	public ResponseEntity<OrderDetail>createOrderDetail(@RequestBody OrderDetailViewModel orderDetailViewModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		OrderDetail orderDetail = this.mapper.convertToOrderDetailEntity(orderDetailViewModel);
		return new ResponseEntity<>(orderDetailService.insertOrUpdate(orderDetail),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderDetail>updateOrderDetail(@PathVariable UUID id,@RequestBody OrderDetailViewModel orderDetailViewModel){
		if(!orderDetailService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("OrderDetail not found with id " + id);
		}
		OrderDetail orderDetail = this.mapper.convertToOrderDetailEntity(orderDetailViewModel);
		return  ResponseEntity.ok(orderDetailService.insertOrUpdate(orderDetail));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteOrderDetail(@PathVariable UUID id){
		return orderDetailService.getOne(id).map(fabric -> {
			orderDetailService.delete(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("OrderDetail not found with id " + id));
	}
}
