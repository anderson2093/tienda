package com.anderson.tiendaback.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID roleId=UUID.randomUUID();

    @Column(nullable = false,length =50)
    private String nameRole;

    @Column(nullable = false,length = 100)
    private String descriptionRole;
}
