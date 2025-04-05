package ru.spbu.liubove.api.mapper;

import org.mapstruct.Mapper;
import ru.spbu.liubove.api.dto.OpenQuestionCardDto;
import ru.spbu.liubove.domain.model.OpenQuestionCard;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionDtoMapper {
    OpenQuestionCard mapToModel(OpenQuestionCardDto dto);
    OpenQuestionCardDto mapToDto(OpenQuestionCard question);
    List<OpenQuestionCard> mapToModel(List<OpenQuestionCardDto> dtos);
    List<OpenQuestionCardDto> mapToDto(List<OpenQuestionCard> questions);
}
