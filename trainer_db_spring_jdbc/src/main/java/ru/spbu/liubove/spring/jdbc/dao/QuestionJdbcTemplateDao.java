package ru.spbu.liubove.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.spbu.liubove.domain.model.OpenQuestionCard;
import ru.spbu.liubove.domain.repo.QuestionRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Repository
public class QuestionJdbcTemplateDao implements QuestionRepository {
    private static final String DDL_QUERY = """
          CREATE TABLE questions (id bigint PRIMARY KEY, question VARCHAR(64), expected_answer VARCHAR(256))
          """;
    private static final String FIND_ALL_QUERY = """
          SELECT id, question, expected_answer FROM questions
          """;
    private static final String FIND_BY_ID_QUERY = """
          SELECT id, question, expected_answer FROM questions WHERE id = ?
          """;
    private static final String INSERT_QUESTION_QUERY = """
          INSERT INTO questions(id, question, expected_answer) VALUES (?, ?, ?)
          """;
    private static final String UPDATE_QUESTION_QUERY = """
          UPDATE questions SET id=?, question=?, expected_answer=?
          """;
    private static final String DELETE_QUESTION_QUERY = """
          DELETE FROM questions WHERE id=?
          """;
    private final JdbcTemplate jdbcTemplate;
    public QuestionJdbcTemplateDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        initDataBase();
    }

    public void initDataBase() {
        jdbcTemplate.execute(DDL_QUERY);
    }

    @Override
    public List<OpenQuestionCard> findAll() {
        return jdbcTemplate.query(
            FIND_ALL_QUERY,
            (ResultSet rs, int rowNum) ->
                new OpenQuestionCard(
                    rs.getLong("id"),
                    rs.getString("question"),
                    rs.getString("expected_answer")
                )
        );
    }

    @Override
    public Optional<OpenQuestionCard> findById(Long id) {
        List<OpenQuestionCard> tasks = jdbcTemplate.query(
            FIND_BY_ID_QUERY,
            (ResultSet rs, int rowNum) ->
                new OpenQuestionCard(
                    rs.getLong("id"),
                    rs.getString("question"),
                    rs.getString("expected_answer")
                ),
            id
        );
        return tasks.isEmpty() ? Optional.empty() : Optional.of(tasks.getFirst());
    }

    @Override
    public void add(OpenQuestionCard task) {
        jdbcTemplate.update(INSERT_QUESTION_QUERY, task.getId(), task.getQuestion(), task.getExpectedAnswer());
    }
    @Override
    public void update(OpenQuestionCard task) {
        jdbcTemplate.update(UPDATE_QUESTION_QUERY, task.getId(), task.getQuestion(), task.getExpectedAnswer());
    }
    @Override
    public void remove(Long id) {
        jdbcTemplate.update(DELETE_QUESTION_QUERY, id);
    }
}
