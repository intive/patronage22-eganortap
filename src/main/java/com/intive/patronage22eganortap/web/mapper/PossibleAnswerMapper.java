package com.intive.patronage22eganortap.web.mapper;

import com.intive.patronage22eganortap.web.domain.PossibleAnswer;
import com.intive.patronage22eganortap.web.domain.PossibleAnswerDto;
import com.intive.patronage22eganortap.web.domain.QuestionDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(
        config = GlobalMapperConfig.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = QuestionMapper.class
)
public interface PossibleAnswerMapper extends GlobalMapperObject<PossibleAnswerDto, PossibleAnswer> {

    @Override
    PossibleAnswer toEntity(PossibleAnswerDto dto);

    @Override
    PossibleAnswerDto toDto(PossibleAnswer entity);
}
