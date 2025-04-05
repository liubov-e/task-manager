package ru.spbu.liubove;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.spbu.liubove.api.controller.QuestionController;
import ru.spbu.liubove.api.dto.OpenQuestionCardDto;
import ru.spbu.liubove.domain.model.OpenQuestionCard;
import ru.spbu.liubove.domain.repo.QuestionRepository;

import java.util.List;

@SpringBootTest
class QuestionControllerTest {
    @MockitoBean
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionController questionController;

    @Test
    @DisplayName("Question is created and added to repo")
    void testQuestionController() {
        Mockito.when(questionRepository.findAll())
            .thenReturn(List.of(new OpenQuestionCard(12L, "Why does anything exist?", "Khz")));
        List<OpenQuestionCardDto> list = questionController.getAll();
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(12L, list.getFirst().getId());
        Assertions.assertEquals("Why does anything exist?", list.getFirst().getQuestion());
        Assertions.assertEquals("Khz", list.getFirst().getExpectedAnswer());
    }
}
