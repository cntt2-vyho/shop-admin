package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.UserModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByEmail(String email);

    List<UserModel> findAllByUsernameContaining(String term);
}
