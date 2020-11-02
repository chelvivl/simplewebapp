package com.mastery.java.task.rest.mappers;

import com.mastery.java.task.dao.model.AbstractEntity;
import com.mastery.java.task.dto.AbstractDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface DtoMapper<MODEL extends AbstractEntity, RESOURCE extends AbstractDto> {
    RESOURCE toDto(MODEL model);

    default List<RESOURCE> toDto(Iterable<MODEL> iterable) {
        return StreamSupport.stream(iterable.spliterator(), true)
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}