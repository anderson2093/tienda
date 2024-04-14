package com.anderson.tiendaback.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.tiendaback.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{

}
