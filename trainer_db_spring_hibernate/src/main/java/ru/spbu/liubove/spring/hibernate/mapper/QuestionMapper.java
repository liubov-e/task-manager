package ru.spbu.liubove.spring.hibernate.mapper;

import org.mapstruct.Mapper;
import ru.spbu.liubove.domain.model.OpenQuestionCard;
import ru.spbu.liubove.spring.hibernate.entity.OpenQuestionCardEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    OpenQuestionCard mapToModel(OpenQuestionCardEntity entity);
    OpenQuestionCardEntity mapToEntity(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardEntity> entities);
    List<OpenQuestionCard> mapToEntity(List<OpenQuestionCard> questions);
}
