package com.justcoffeeshop.utils;

import com.justcoffeeshop.models.ProductModel;
import com.justcoffeeshop.controllers.api.dto.ProductDTO;

public class ModelMapper {

    public static ProductDTO toProductDTO(ProductModel product) {
        if (product == null)
            return null;
        return ProductDTO.builder().id(product.getId())
                .price(product.getPrice())
                .productName(product.getProductName())
                .supplierId(product.getSupplierModel().getId())
                .categoryId(product.getCategoryModel().getId())
                .unit(product.getUnit())
                .build();
    }
}
