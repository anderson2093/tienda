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

import com.anderson.tiendaback.models.Category;
import com.anderson.tiendaback.repositories.CategoryRepository;
import com.anderson.tiendaback.services.CategoryService;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImpl extends CRUDImpl<Category,UUID> implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	protected IGenericRepo<Category, UUID> getRepo() {
		return categoryRepository;
	}
}
