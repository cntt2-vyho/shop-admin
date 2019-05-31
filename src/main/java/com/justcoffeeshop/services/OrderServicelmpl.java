package com.justcoffeeshop.services;

import org.springframework.stereotype.Service;
import com.justcoffeeshop.models.OrderDetailModel;
import com.justcoffeeshop.models.OrderModel;

import java.util.List;


@Service
public class OrderServicelmpl extends BaseService<OrderModel> implements OrderService {

    @Override
    public List<OrderDetailModel> findAllOrderDetailById(Long id) {
        OrderModel orderModel = baseRepository.getOne(id);
        return orderModel.getOrderDetails();
    }
}
