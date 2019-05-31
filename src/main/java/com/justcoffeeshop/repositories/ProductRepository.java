package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.ProductModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<ProductModel, Long> {
    List<ProductModel> findAllByCategoryModel(Long id);
}
