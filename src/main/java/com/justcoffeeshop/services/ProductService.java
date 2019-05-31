package com.justcoffeeshop.services;


import com.justcoffeeshop.models.ProductModel;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductModel> findAll();

    List<ProductModel> findAllByCategoryModel(Long id);

    List<ProductModel> search(String term);

    Optional<ProductModel> findById(Long id);

    boolean update(ProductModel product);

    ProductModel save(ProductModel product);

    boolean delete(Long id);
}
