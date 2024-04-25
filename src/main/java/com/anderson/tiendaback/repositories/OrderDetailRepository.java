package com.anderson.tiendaback.repositories;

import java.util.List;
import java.util.UUID;

import com.anderson.tiendaback.models.OrderDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDetailRepository extends IGenericRepo<OrderDetail, UUID>{

    @Modifying
    @Query(value = "INSERT INTO order_details(order_id, product_id) VALUES(:orderId, :productId)", nativeQuery = true)
    UUID saveProduct(@Param("orderId") UUID orderId, @Param("productId") UUID productId);


    @Query("FROM OrderDetail ce WHERE ce.order.orderId = :orderId")
    List<OrderDetail> getProductsByOrderId(@Param("orderId") UUID orderId);
}
