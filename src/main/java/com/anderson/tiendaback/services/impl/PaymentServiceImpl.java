package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.Payment;
import com.anderson.tiendaback.repositories.PaymentRepository;
import com.anderson.tiendaback.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public Payment insertOrUpdate(Payment entity) {
		// TODO Auto-generated method stub
		return paymentRepository.save(entity);
	}

	@Override
	public Optional<Payment> getOne(UUID id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

	@Override
	public List<Payment> getAll(int page, int size, String sortDir, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(id);
	}

	@Override
	public Page<Payment> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		return null;
	}

}
