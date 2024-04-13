package com.anderson.tiendaback.models;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="products" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true,name = "productId")
    private UUID productId=UUID.randomUUID();
    
    @NotNull
    private String nameProduct;
    
    @NotNull
    private String descriptionProduct;
    
    @NotNull
    private Double priceProduct;

    @ManyToOne
    private Category category;
    
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(UUID productId, @NotNull String nameProduct, @NotNull String descriptionProduct,
			@NotNull Double priceProduct, Category category) {
		super();
		this.productId = productId;
		this.nameProduct = nameProduct;
		this.descriptionProduct = descriptionProduct;
		this.priceProduct = priceProduct;
		this.category = category;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
    
}
