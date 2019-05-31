package com.justcoffeeshop.services;

import org.springframework.stereotype.Service;
import com.justcoffeeshop.models.ShipperModel;

import java.util.List;

@Service
public class ShipperServicelmpl extends BaseService<ShipperModel> implements ShipperService {

    @Override
    public List<ShipperModel> search(String term) {
        return baseRepository.findByAttributeContainsText("shipperName", term);
    }
}
