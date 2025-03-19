package ru.spbu.liubove.storage;

import org.springframework.stereotype.Repository;
import ru.spbu.liubove.domain.model.OpenQuestionCard;
import ru.spbu.liubove.domain.repo.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class QuestionInMemoryStorage implements QuestionRepository {
    private final Map<Long, OpenQuestionCard> cards = new HashMap<>();

    public List<OpenQuestionCard> findAll() {
        return cards.values().stream().toList();
    }

    public Optional<OpenQuestionCard> findById(Long id) {
        return Optional.ofNullable(cards.get(id));
    }

    public void add(OpenQuestionCard task) {
        cards.put(task.getId(), task);
    }

    public void update(OpenQuestionCard task) {
        if (cards.computeIfPresent(task.getId(), (id, oldTask) -> task) == null) {
            throw new IllegalArgumentException("Cannot update absent task");
        }
    }

    public void remove(Long id) {
        if (cards.remove(id) == null) {
            throw new IllegalArgumentException("Cannot remove absent task");
        }
    }
}
