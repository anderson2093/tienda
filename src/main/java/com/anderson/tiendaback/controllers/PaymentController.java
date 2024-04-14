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
import org.springframework.web.bind.annotation.RequestParam;

import com.anderson.tiendaback.Mapper;
import com.anderson.tiendaback.exception.ResourceNotFoundException;
import com.anderson.tiendaback.models.Payment;
import com.anderson.tiendaback.services.PaymentService;
import com.anderson.tiendaback.viewModels.PaymentViewModel;

import jakarta.validation.ValidationException;

public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private Mapper mapper;
	
	@GetMapping(params = {"page","size","sortDir","sort"})
	public ResponseEntity<List<Payment>> getPayment(@RequestParam("page")int page,@RequestParam("size")int size,@RequestParam("sortDir")String sortDir,@RequestParam("sort")String sort){
		List<Payment> payments = paymentService.getAll(page, size, sortDir, sort).stream().map(payment->{
			return payment;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<Payment>>(payments,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment>getPaymentById(@PathVariable UUID id){
		Optional<Payment> payment = paymentService.getOne(id);
		if(!payment.isPresent()) {
			new ResourceNotFoundException("Id "+id+ "is not existed");
		}
		return ResponseEntity.ok(payment.get());
	}
	
	@PostMapping
	public ResponseEntity<Payment>createFabric(@RequestBody PaymentViewModel paymentViewModel, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Payment payment = this.mapper.convertToPaymentEntity(paymentViewModel);
		return new ResponseEntity<>(paymentService.insertOrUpdate(payment),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Payment>updateFabric(@PathVariable UUID id,@RequestBody PaymentViewModel paymentViewModel){
		if(!paymentService.getOne(id).isPresent()) {
        	new ResourceNotFoundException("Payment not found with id " + id);
		}
		Payment payment = this.mapper.convertToPaymentEntity(paymentViewModel);
		return  ResponseEntity.ok(paymentService.insertOrUpdate(payment));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deletePayment(@PathVariable UUID id){
		return paymentService.getOne(id).map(fabric -> {
			paymentService.delete(id);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id " + id));
	}
}
