package com.justcoffeeshop.services;

import org.springframework.stereotype.Service;
import com.justcoffeeshop.models.CustomerModel;

import java.util.List;

@Service
public class CustomerServiceImpl extends BaseService<CustomerModel> implements CustomerService {

    @Override
    public List<CustomerModel> search(String term) {
        return baseRepository.findByAttributeContainsText("customerName", term);
        // select * from shop_customers where shop_customers.customer_name like %term%
    }
}
