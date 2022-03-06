package com.intive.patronage22eganortap.web.mapper;

import com.intive.patronage22eganortap.web.domain.Poll;
import com.intive.patronage22eganortap.web.domain.PollDto;
import com.intive.patronage22eganortap.web.domain.QuestionDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = QuestionMapper.class
)
public interface PollMapper extends GlobalMapperObject<PollDto, Poll>{

    @Override
    @Mapping(target = "creationDate", ignore = true)
    Poll toEntity(PollDto dto);

    @Override
    PollDto toDto(Poll entity);
}
