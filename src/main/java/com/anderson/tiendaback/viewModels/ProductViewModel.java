package com.anderson.tiendaback.viewModels;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class ProductViewModel {

    private UUID productId;
    
    @NotNull
    private String nameProduct;
    
    @NotNull
    private String descriptionProduct;
    
    @NotNull
    private Double priceProduct;
    
    private UUID categoryId;

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

	public UUID getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(UUID categoryId) {
		this.categoryId = categoryId;
	}
    
    
	
}
