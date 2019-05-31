package com.justcoffeeshop.services;

import com.justcoffeeshop.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import com.justcoffeeshop.models.ProductModel;

import java.util.List;

@Service
public class ProductServicelmpl extends BaseService<ProductModel> implements ProductService {

    private final ProductRepository productRepository;

    public ProductServicelmpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductModel> findAllByCategoryModel(Long id) {
        return productRepository.findAllByCategoryModel(id);
    }

    public List<ProductModel> search(String term) {
        return baseRepository.findByAttributeContainsText("productName", term);
    }
}
