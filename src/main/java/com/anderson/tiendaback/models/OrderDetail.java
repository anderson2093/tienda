package com.anderson.tiendaback.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "order-details")
public class OrderDetail {
	@Id
	@Column(name = "orderDetailId")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID orderDetailId=UUID.randomUUID();
	
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
    
    private Integer quantity;
    
    private Double price;

    
}
