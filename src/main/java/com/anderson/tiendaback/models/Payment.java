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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "paymentId")
	private UUID paymentId=UUID.randomUUID();

	@Column(nullable = false,length =50)
	private String nOperation;

	@Column(length =50)
	private Double mount;

	@Column(nullable = false,length =50)
	private Date datePayment;
	
	@OneToOne
	private Order order;

}
