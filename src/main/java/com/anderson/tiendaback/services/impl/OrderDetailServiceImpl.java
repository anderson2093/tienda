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

import com.anderson.tiendaback.models.OrderDetail;
import com.anderson.tiendaback.repositories.OrderDetailRepository;
import com.anderson.tiendaback.services.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDetail insertOrUpdate(OrderDetail entity) {
		// TODO Auto-generated method stub
		return orderDetailRepository.save(entity);
	}

	@Override
	public Optional<OrderDetail> getOne(UUID id) {
		// TODO Auto-generated method stub
		return orderDetailRepository.findById(id);
	}

	@Override
	public List<OrderDetail> getAll(int page, int size, String sortDir, String sort) {
		// TODO Auto-generated method stub
		PageRequest pageReq = PageRequest.of(page, size,Sort.Direction.fromString(sortDir),sort);
		return orderDetailRepository.findAll(pageReq).getContent();
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		orderDetailRepository.deleteById(id);
	}

	@Override
	public Page<OrderDetail> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return orderDetailRepository.findAll(pageable);
	}

}
