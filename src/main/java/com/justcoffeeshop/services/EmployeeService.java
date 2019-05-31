package com.justcoffeeshop.services;

import com.justcoffeeshop.models.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeModel> findAll();

    List<EmployeeModel> search(String term);

    Optional<EmployeeModel> findById(Long id);

    boolean update(EmployeeModel employee);

    EmployeeModel save(EmployeeModel employee);

    boolean delete(Long id);
}
