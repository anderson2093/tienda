package com.anderson.tiendaback.services.impl;


import java.util.UUID;

import com.anderson.tiendaback.repositories.IGenericRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.Product;
import com.anderson.tiendaback.repositories.ProductRepository;
import com.anderson.tiendaback.services.ProductService;

@Service
public class ProductServiceImpl extends CRUDImpl<Product,UUID> implements ProductService {

	@Autowired
	private ProductRepository productRepository;


	@Override
	protected IGenericRepo<Product, UUID> getRepo() {
		return productRepository;
	}
}
