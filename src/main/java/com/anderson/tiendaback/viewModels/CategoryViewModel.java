package com.anderson.tiendaback.viewModels;

import java.util.UUID;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.validation.constraints.NotNull;

public class CategoryViewModel {

	@NotNull
	private UUID categoryId;
	
	@NotNull
	private String nameCategory;

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	
}
