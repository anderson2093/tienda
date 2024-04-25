package com.anderson.tiendaback.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.anderson.tiendaback.dto.PaymentDTO;
import com.anderson.tiendaback.exception.ModelNotFoundException;
import com.anderson.tiendaback.models.Payment;
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


import com.anderson.tiendaback.services.PaymentService;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ModelMapper mapper;
	@GetMapping
	public ResponseEntity<List<PaymentDTO>> findAll() {
		List<PaymentDTO> list = paymentService.findAll().stream().map(p -> mapper.map(p, PaymentDTO.class)).collect(Collectors.toList());

		return new ResponseEntity<>(list, OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PaymentDTO> findById(@PathVariable("id") UUID id) {
		Payment obj = paymentService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		} else {
			return new ResponseEntity<>(mapper.map(obj, PaymentDTO.class), OK);
		}
	}


	@PostMapping
	public ResponseEntity<Void> save(@RequestBody PaymentDTO dto){
		Payment obj = paymentService.save(mapper.map(dto, Payment.class));
		//localhost:8080/payment/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getPaymentId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Payment> update(@RequestBody PaymentDTO dto) {
		Payment obj = paymentService.update(mapper.map(dto, Payment.class));
		return new ResponseEntity<>(obj, OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
		Payment obj = paymentService.findById(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NOT FOUND: " + id);
		}
		paymentService.delete(id);
		return new ResponseEntity<>(NO_CONTENT);
	}
}
