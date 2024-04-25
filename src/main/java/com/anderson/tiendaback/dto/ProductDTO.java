package com.anderson.tiendaback.dto;

import java.util.List;
import java.util.UUID;

import com.anderson.tiendaback.models.OrderDetail;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDTO {
	@EqualsAndHashCode.Include
    private UUID productId;
    
    @NotNull
    private String nameProduct;
    
    @NotNull
    private String descriptionProduct;
    
    @NotNull
    private Double priceProduct;

	@NotNull
	private CategoryDTO category;

    @JsonManagedReference
    @NotNull
    private List<OrderDetail> orderDetails;


}
