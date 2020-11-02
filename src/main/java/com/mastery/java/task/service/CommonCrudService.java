package com.mastery.java.task.service;

import com.mastery.java.task.dao.model.AbstractEntity;

import java.util.Optional;

public interface CommonCrudService<T extends AbstractEntity> {
    T save(T t);

    Optional<T> findById(Long id);

    Iterable<T> findAll();

    void delete(T t);

}