package com.anderson.tiendaback.viewModels;

import java.util.UUID;


import jakarta.validation.constraints.NotNull;

public class OrderDetailViewModel {

	private UUID orderId;
	
	private UUID productId;
	
	@NotNull
	private Double priceProduct;
	
	@NotNull
	private Integer quantityProduct;
	
	@NotNull
	private Double total;

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public Double getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Double priceProduct) {
		this.priceProduct = priceProduct;
	}

	public Integer getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
