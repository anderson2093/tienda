package com.anderson.tiendaback.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	

    @OneToMany(mappedBy = "order")
	private List<OrderDetail>orderDetails;
	
	@OneToOne
	@JsonIgnore
	private Payment payment;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
		payment = new Payment();
		orderDetails = new ArrayList<>();
	}

	public Order(UUID orderId, @NotNull Double mount, @NotNull User user) {
		super();
		this.orderId = orderId;
		this.mount = mount;
		this.user = user;
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



	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}


	
}
