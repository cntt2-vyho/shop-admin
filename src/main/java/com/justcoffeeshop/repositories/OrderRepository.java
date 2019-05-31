package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.OrderModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<OrderModel, Long> {

}
