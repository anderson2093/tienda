package com.anderson.tiendaback.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDTO {
	@EqualsAndHashCode.Include
	private UUID userId;
	@NotNull
	private String password;

	@NotNull
	private String username;

	@JsonManagedReference
	@NotNull
	private List<OrderDTO> orders;
}
