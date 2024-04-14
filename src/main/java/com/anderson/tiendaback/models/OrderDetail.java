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
@Table(name = "order-details")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "orderDetailId")
	private UUID orderDetailId = UUID.randomUUID();
	@NotNull
	private Double priceProduct;
	
	@NotNull
	private Integer quantityProduct;
	
	@NotNull
	private Double total;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Order order;       

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(UUID orderDetailId, @NotNull Double priceProduct, @NotNull Integer quantityProduct,
			@NotNull Double total, Product product, Order order) {
		super();
		this.orderDetailId = orderDetailId;
		this.priceProduct = priceProduct;
		this.quantityProduct = quantityProduct;
		this.total = total;
		this.product = product;
		this.order = order;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
	
	
	
}
