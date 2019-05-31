package com.justcoffeeshop.services;


import com.justcoffeeshop.models.OrderDetailModel;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {

    List<OrderDetailModel> findAll();

    Optional<OrderDetailModel> findById(Long id);

    boolean update(OrderDetailModel orderDetail);

    OrderDetailModel save(OrderDetailModel orderDetail);

    boolean delete(Long id);
}
