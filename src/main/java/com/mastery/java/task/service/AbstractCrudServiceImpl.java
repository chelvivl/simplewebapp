package com.mastery.java.task.service;

import com.mastery.java.task.dao.CommonJpaDao;
import com.mastery.java.task.dao.model.AbstractEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.Optional;


@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
abstract public class AbstractCrudServiceImpl<E extends AbstractEntity> implements CommonCrudService<E> {

    @NonNull
    protected final CommonJpaDao<E> repository;

    @Override
    public E save(E t) {
        return repository.save(t);
    }

    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }


    @Override
    public void delete(E t) {
        repository.delete(t);
    }

}