package com.mastery.java.task.rest.mappers;

import com.mastery.java.task.dao.model.AbstractEntity;
import com.mastery.java.task.dto.AbstractDto;

public interface Mapper<MODEL extends AbstractEntity, DTO extends AbstractDto> extends DtoMapper<MODEL, DTO> {
    MODEL toModel(DTO dto);

    MODEL update(MODEL current, DTO dto);
}