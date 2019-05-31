package com.justcoffeeshop.services;

import com.justcoffeeshop.models.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserModel> findAll();

    List<UserModel> search(String term);

    Optional<UserModel> findById(Long id);

    boolean update(UserModel userModel);

    UserModel save(UserModel userModel);

    void register(UserModel userModel) throws Exception;

    boolean delete(Long id);
}
