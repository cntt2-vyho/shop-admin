package com.justcoffeeshop.services;

import com.justcoffeeshop.models.OrderDetailModel;
import com.justcoffeeshop.models.OrderModel;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderModel> findAll();

    List<OrderDetailModel> findAllOrderDetailById(Long id);

    Optional<OrderModel> findById(Long id);

    boolean update(OrderModel order);

    OrderModel save(OrderModel order);

    boolean delete(Long id);
}
