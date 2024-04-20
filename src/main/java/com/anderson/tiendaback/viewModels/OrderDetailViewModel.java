package com.anderson.tiendaback.viewModels;

import java.util.UUID;

import com.anderson.tiendaback.models.Product;


public class OrderDetailViewModel {

	private UUID orderDetailId;
	

    private UUID orderId;
    

    private UUID productId;
    
    private Integer quantity;
    
    private Double price;

	public UUID getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(UUID orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
    
    
}


