package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.UUID;

import com.anderson.tiendaback.repositories.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.OrderDetail;
import com.anderson.tiendaback.repositories.OrderDetailRepository;
import com.anderson.tiendaback.services.OrderDetailService;

@Service
public class OrderDetailServiceImpl extends CRUDImpl<OrderDetail,UUID> implements OrderDetailService{

	@Autowired
	private OrderDetailRepository orderDetailRepository;


	@Override
	protected IGenericRepo<OrderDetail, UUID> getRepo() {
		return orderDetailRepository;
	}

	@Override
	public List<OrderDetail> getProductsByOrderId(UUID orderId) {
		return orderDetailRepository.getProductsByOrderId(orderId);
	}
}
