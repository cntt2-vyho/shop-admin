package com.justcoffeeshop.repositories;

import com.justcoffeeshop.models.RoleModel;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<RoleModel, Long> {

    RoleModel findByName(String s);
}
