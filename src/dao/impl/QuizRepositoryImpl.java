package dao.impl;

import dao.QuizRepository;
import model.Quiz;

import java.util.List;
import java.util.stream.Collectors;

public class QuizRepositoryImpl extends RepositoryMemoryImpl<Long, Quiz> implements
        QuizRepository {


    @Override
    public List<Quiz> findByDuration(int expectedDuration) {
        return this.findAll()
                .stream().filter(quiz -> quiz.getExpectedDuration() == expectedDuration)
                .collect(Collectors.toList());
    }

    

}
