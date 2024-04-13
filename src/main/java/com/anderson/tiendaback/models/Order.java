package com.anderson.tiendaback.models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true,name = "orderId")	
	private UUID orderId=UUID.randomUUID();

	@NotNull
	private Double mount;
	
	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderDetail>orderDetails;
	
	@OneToOne
	private Payment payment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(UUID orderId, @NotNull Double mount, @NotNull User user, Payment payment) {
		super();
		this.orderId = orderId;
		this.mount = mount;
		this.user = user;
		this.payment = payment;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public Double getMount() {
		return mount;
	}

	public void setMount(Double mount) {
		this.mount = mount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
}
