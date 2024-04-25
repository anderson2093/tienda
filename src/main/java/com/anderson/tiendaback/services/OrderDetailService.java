package com.anderson.tiendaback.services;


import com.anderson.tiendaback.models.OrderDetail;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService extends ICRUDService<OrderDetail, UUID> {
    List<OrderDetail> getProductsByOrderId(@Param("orderId") UUID orderId);
}
