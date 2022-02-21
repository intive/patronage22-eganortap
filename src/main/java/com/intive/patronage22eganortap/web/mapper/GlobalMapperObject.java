package com.intive.patronage22eganortap.web.mapper;

import java.util.Collection;

public interface GlobalMapperObject<D,E> {
    E toEntity(D dto);
    D toDto(E entity);

    Collection<E> toEntities(Collection<D> dtos);
    Collection<D> toDtos(Collection<E> entities);

}
