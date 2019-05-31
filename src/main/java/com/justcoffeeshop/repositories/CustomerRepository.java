package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerModel, Long> {

}
