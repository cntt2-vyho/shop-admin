package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.OrderDetailModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends BaseRepository<OrderDetailModel, Long> {

}
