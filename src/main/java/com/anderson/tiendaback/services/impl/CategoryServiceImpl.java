package com.anderson.tiendaback.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.anderson.tiendaback.models.Category;
import com.anderson.tiendaback.repositories.CategoryRepository;
import com.anderson.tiendaback.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category insertOrUpdate(Category entity) {
		// TODO Auto-generated method stub
		return categoryRepository.save(entity);
	}

	@Override
	public Optional<Category> getOne(UUID id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> getAll(int page, int size, String sortDir, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UUID id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

	@Override
	public Page<Category> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		// TODO Auto-generated method stub
		return null;
	}

}