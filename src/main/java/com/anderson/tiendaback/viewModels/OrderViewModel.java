package com.anderson.tiendaback.viewModels;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class OrderViewModel {

	private UUID orderId;

	@NotNull
	private Double mount;
	
	private UUID paymentId;
	
	private UUID userId;

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

	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	
	
	
}
