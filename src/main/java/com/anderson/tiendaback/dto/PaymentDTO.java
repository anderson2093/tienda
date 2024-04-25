package com.anderson.tiendaback.dto;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentDTO {
	@EqualsAndHashCode.Include
	private UUID paymentId;
	
	@NotNull
	private String nOperation;
	
	@NotNull
	private Double mount;
	
	@NotNull
	private Date datePayment;

	@NotNull
	private OrderDTO order;

}
