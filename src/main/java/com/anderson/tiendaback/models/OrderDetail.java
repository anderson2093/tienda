package com.anderson.tiendaback.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order-details")
public class OrderDetail {
	@Id
	@Column(name = "orderId")
	private UUID orderId;
	
	@Id
	@Column(name = "productId")
	private UUID productId;
	
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



	public OrderDetail(UUID orderId, UUID productId, @NotNull Double priceProduct, @NotNull Integer quantityProduct,
			@NotNull Double total, Product product, Order order) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.priceProduct = priceProduct;
		this.quantityProduct = quantityProduct;
		this.total = total;
		this.product = product;
		this.order = order;
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
	
	
}
