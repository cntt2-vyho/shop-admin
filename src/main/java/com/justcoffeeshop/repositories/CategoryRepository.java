package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.CategoryModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryModel, Long> {

}
