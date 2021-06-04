package dao.impl;


import dao.KeyGenerator;
import dao.QuizResultRepository;
import model.QuizResult;

public class QuizResultRepositoryImpl extends RepositoryMemoryImpl<Long, QuizResult>
        implements QuizResultRepository {


    public QuizResultRepositoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }
}
