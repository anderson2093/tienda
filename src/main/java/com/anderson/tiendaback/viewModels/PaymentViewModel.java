package com.anderson.tiendaback.viewModels;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class PaymentViewModel {

	private UUID paymentId;
	
	@NotNull
	private String nOperation;
	
	@NotNull
	private Double mount;
	
	@NotNull
	private Date datePayment;
	
	private UUID orderId;

	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}

	public String getnOperation() {
		return nOperation;
	}

	public void setnOperation(String nOperation) {
		this.nOperation = nOperation;
	}

	public Double getMount() {
		return mount;
	}

	public void setMount(Double mount) {
		this.mount = mount;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}
	
	
}
