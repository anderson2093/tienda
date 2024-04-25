package com.anderson.tiendaback.models;

import java.util.List;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="products" )
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true,name = "productId")
    private UUID productId=UUID.randomUUID();

	@Column(nullable = false,length =50)
    private String nameProduct;
    

	@Column(nullable = false,length =100)
	private String descriptionProduct;

	@Column(nullable = false,length =50)
    private Double priceProduct;

    @ManyToOne
    private Category category;
    
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

}
