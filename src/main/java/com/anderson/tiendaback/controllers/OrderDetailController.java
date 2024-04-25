package com.anderson.tiendaback.controllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.tiendaback.models.OrderDetail;
import com.anderson.tiendaback.services.OrderDetailService;
import com.anderson.tiendaback.dto.OrderDetailDTO;


@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/{idConsult}")
	public ResponseEntity<List<OrderDetailDTO>> getConsultsById(@PathVariable("idConsult") UUID idConsult){
		List<OrderDetail> lst = orderDetailService.getProductsByOrderId(idConsult);
		List<OrderDetailDTO> lstDTO = mapper.map(lst, new TypeToken<List<OrderDetailDTO>>() {}.getType());
		return new ResponseEntity<>(lstDTO, HttpStatus.OK);
	}
}
