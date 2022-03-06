package com.intive.patronage22eganortap.web.mapper;


import com.intive.patronage22eganortap.web.domain.Question;
import com.intive.patronage22eganortap.web.domain.QuestionDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        config = GlobalMapperConfig.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {PossibleAnswerMapper.class, UserAnswerMapper.class}
)
public interface QuestionMapper extends GlobalMapperObject<QuestionDto, Question> {

    @Override
    Question toEntity(QuestionDto dto);

    @Override
    QuestionDto toDto(Question entity);
}
