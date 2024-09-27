package by.senla.tatianabakach.mapper;

import by.senla.tatianabakach.dto.BaseDTO;
import by.senla.tatianabakach.entity.BaseEntity;

public interface BaseMapper<E extends BaseEntity, D extends BaseDTO> {

    E toEntity(D dto);

    D toDto(E entity);
}