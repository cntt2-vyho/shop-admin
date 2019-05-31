package com.justcoffeeshop.services;

import org.springframework.stereotype.Service;
import com.justcoffeeshop.models.SupplierModel;

import java.util.List;

@Service
public class SupplierServicelmpl extends BaseService<SupplierModel> implements SupplierService {

    @Override
    public List<SupplierModel> search(String term) {
        return baseRepository.findByAttributeContainsText("supplierName", term);
    }
}
