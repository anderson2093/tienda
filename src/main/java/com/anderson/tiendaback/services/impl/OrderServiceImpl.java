package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.Order;
import com.anderson.tiendaback.repositories.OrderRepository;
import com.anderson.tiendaback.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order insertOrUpdate(Order entity) {
		// TODO Auto-generated method stub
		return orderRepository.save(entity);
	}

	@Override
	public Optional<Order> getOne(UUID id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id);
	}

	@Override
	public List<Order> getAll(int page, int size, String sortDir, String sort) {
		// TODO Auto-generated method stub
		PageRequest pageReq = PageRequest.of(page, size,Sort.Direction.fromString(sortDir),sort);
		return orderRepository.findAll(pageReq).getContent();
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}

	@Override
	public Page<Order> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return orderRepository.findAll(pageable);
	}

}
