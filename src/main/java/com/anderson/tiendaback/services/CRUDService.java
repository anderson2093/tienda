package com.anderson.tiendaback.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

public interface CRUDService <T>{

	T insertOrUpdate(T entity);

	Optional<T> getOne(UUID id);

	List<T> getAll(int page,int size, String sortDir,String sort);

	void delete(UUID id);

	Page<T> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
}
