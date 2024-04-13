package com.anderson.tiendaback.models;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "paymentId")
	private UUID paymentId=UUID.randomUUID();
	
	@NotNull
	private String nOperation;
	
	@NotNull
	private Double mount;
	
	@NotNull
	private Date datePayment;
	
	@OneToOne
	private Order order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(UUID paymentId, @NotNull String nOperation, @NotNull Double mount, @NotNull Date datePayment,
			Order order) {
		super();
		this.paymentId = paymentId;
		this.nOperation = nOperation;
		this.mount = mount;
		this.datePayment = datePayment;
		this.order = order;
	}

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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
