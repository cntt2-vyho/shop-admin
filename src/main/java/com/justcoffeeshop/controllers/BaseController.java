package com.justcoffeeshop.controllers;

import com.justcoffeeshop.models.BaseModel;
import com.justcoffeeshop.repositories.BaseRepository;
import com.justcoffeeshop.services.BaseService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

public class BaseController<T extends BaseModel<T>> {

    @Getter
    @Autowired
    public EntityManager entityManager;
    @Getter
    @Autowired
    public PlatformTransactionManager transactionManager;
    @Getter
    @Autowired
    public TransactionTemplate transactionTemplate;

    protected BaseRepository<T, ?> baseRepository;

    protected BaseService<T> baseService;

    public BaseController(BaseRepository<T, ?> baseRepository, BaseService<T> baseService) {
        this.baseRepository = baseRepository;
        this.baseService = baseService;
    }

    public BaseRepository<T, ?> getBaseRepository() {
        return baseRepository;
    }
}
