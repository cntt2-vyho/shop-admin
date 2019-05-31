package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.EmployeeModel;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BaseRepository<EmployeeModel, Long> {

}
