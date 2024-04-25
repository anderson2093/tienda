package com.anderson.tiendaback.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true,name = "orderId")
	@EqualsAndHashCode.Include
	private UUID orderId=UUID.randomUUID();

	@Column(nullable = true,length =50)
	private Double mount;
	
	@ManyToOne
	private User user;
	

    @OneToMany(mappedBy = "order")
	private List<OrderDetail>orderDetails;
	
	@OneToOne
	@JsonIgnore
	private Payment payment;

	
}
