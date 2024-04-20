package com.anderson.tiendaback.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order-details")
public class OrderDetail {
	@Id
	@Column(name = "orderDetailId")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID orderDetailId=UUID.randomUUID();
	
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    
    private Integer quantity;
    
    private Double price;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(UUID orderDetailId, Order order, Product product, Integer quantity, Double price) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public UUID getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(UUID orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
