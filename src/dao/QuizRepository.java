package dao;

import model.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizRepository extends Repository<Long, Quiz> {

    List<Quiz> findByDuration(int expectedDuration);
    // todo check if allTogether title, description;
    Set<Quiz> findBy(String criteria);

}
