package com.anderson.tiendaback.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true,name = "categoryId")	
	private UUID categoryId = UUID.randomUUID();
	
	@NotNull
	private String nameCategory;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Product> products;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
		products=new ArrayList<Product>();
	}

	public Category(UUID categoryId, @NotNull @UniqueElements String nameCategory) {
		super();
		this.categoryId = categoryId;
		this.nameCategory = nameCategory;
	}

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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
