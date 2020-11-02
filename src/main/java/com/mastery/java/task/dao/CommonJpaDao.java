package com.mastery.java.task.dao;

import com.mastery.java.task.dao.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonJpaDao<T extends AbstractEntity> extends JpaRepository<T, Long> {
}