package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.anderson.tiendaback.repositories.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.Payment;
import com.anderson.tiendaback.repositories.PaymentRepository;
import com.anderson.tiendaback.services.PaymentService;

@Service
public class PaymentServiceImpl extends CRUDImpl<Payment,UUID> implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;


	@Override
	protected IGenericRepo<Payment, UUID> getRepo() {
		return paymentRepository;
	}
}
