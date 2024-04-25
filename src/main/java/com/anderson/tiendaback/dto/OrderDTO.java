package com.anderson.tiendaback.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderDTO {
	@EqualsAndHashCode.Include
	private UUID orderId;

	@NotNull
	private Double mount;

	@NotNull
	private UserDTO user;

	@JsonManagedReference
	@NotNull
	private List<OrderDetailDTO> details;
}
