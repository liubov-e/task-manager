package ru.spbu.liubove.domain.model;

import java.util.Objects;

public class OpenQuestionCard {
    private final Long id;
    private final String question;
    private final String expectedAnswer;

    public OpenQuestionCard(Long id, String question, String expectedAnswer) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(question);
        Objects.requireNonNull(expectedAnswer);
        this.id = id;
        this.question = question;
        this.expectedAnswer = expectedAnswer;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    @Override
    public String toString() {
        return "{" +
            "id=" + id +
            ", question='" + question + '\'' +
            ", expectedAnswer='" + expectedAnswer + '\'' +
            '}';
    }
}
