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
public class CategoryDTO {

	@EqualsAndHashCode.Include
	private UUID categoryId;
	
	@NotNull
	private String nameCategory;

	@JsonManagedReference
	@NotNull
	private List<ProductDTO>products;

}
