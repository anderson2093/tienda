package com.anderson.tiendaback.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderListProductDTO {

    @NotNull
    private OrderDTO order;

    @NotNull
    private List<ProductDTO>lstProduct;
}
