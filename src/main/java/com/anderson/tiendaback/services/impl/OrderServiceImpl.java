package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.UUID;

import com.anderson.tiendaback.models.Product;
import com.anderson.tiendaback.repositories.IGenericRepo;
import com.anderson.tiendaback.repositories.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.Order;
import com.anderson.tiendaback.repositories.OrderRepository;
import com.anderson.tiendaback.services.OrderService;

@Service
public class OrderServiceImpl extends CRUDImpl<Order,UUID> implements OrderService{

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	protected IGenericRepo<Order, UUID> getRepo() {
		return orderRepository;
	}

	@Override
	public Order saveTransactional(Order order, List<Product> products) {
		orderRepository.save(order);

		//Insertando en la tabla consult_exam
		products.forEach(ex -> orderDetailRepository.saveProduct(order.getOrderId(), ex.getProductId()));

		return order;
	}
}
