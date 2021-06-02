package dao;

import model.Quiz;

import java.util.List;

public interface QuizRepository extends Repository<Long, Quiz> {

    List<Quiz> findByDuration(int expectedDuration);
}
