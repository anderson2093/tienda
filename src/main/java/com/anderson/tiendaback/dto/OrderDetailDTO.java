package com.anderson.tiendaback.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDetailDTO {
	@EqualsAndHashCode.Include
	private UUID orderDetailId;
	
	@NotNull
    private OrderDTO order;

	@NotNull

    private ProductDTO product;

	@NotNull
	private Integer quantity;

	@NotNull
	private Double price;


}


