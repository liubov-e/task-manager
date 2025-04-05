package ru.spbu.liubove.spring.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.spbu.liubove.domain.model.OpenQuestionCard;
import ru.spbu.liubove.domain.repo.QuestionRepository;
import ru.spbu.liubove.spring.hibernate.entity.OpenQuestionCardEntity;
import ru.spbu.liubove.spring.hibernate.mapper.QuestionMapper;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class QuestionHibernateDao implements QuestionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final QuestionMapper mapper;

    public QuestionHibernateDao(QuestionMapper mapper) {
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OpenQuestionCard> findAll() {
        return mapper.mapToModel(
            entityManager
                .createQuery("SELECT question FROM OpenQuestionCardEntity question", OpenQuestionCardEntity.class)
                .getResultList()
        );
    }

    private Optional<OpenQuestionCardEntity> findEntityById(Long id) {
        return entityManager.createQuery("SELECT question FROM OpenQuestionCardEntity question WHERE question.id = ?1", OpenQuestionCardEntity.class)
            .setParameter(1, id)
            .getResultStream()
            .findFirst();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OpenQuestionCard> findById(Long id) {
        return findEntityById(id).map(mapper::mapToModel);
    }

    @Override
    public void add(OpenQuestionCard question) {
        entityManager.merge(mapper.mapToEntity(question));
    }

    @Override
    public void update(OpenQuestionCard question) {
        entityManager.merge(mapper.mapToEntity(question));
    }

    @Override
    public void remove(Long id) {
        findEntityById(id).ifPresent(entityManager::remove);
    }
}
