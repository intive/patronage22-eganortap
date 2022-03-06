package com.intive.patronage22eganortap.web.mapper;

import com.intive.patronage22eganortap.web.domain.UserAnswer;
import com.intive.patronage22eganortap.web.domain.UserAnswerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
        config = GlobalMapperConfig.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface UserAnswerMapper extends GlobalMapperObject<UserAnswerDto, UserAnswer> {

    @Override
    UserAnswer toEntity(UserAnswerDto dto);

    @Override
    @InheritInverseConfiguration
    UserAnswerDto toDto(UserAnswer entity);
}
