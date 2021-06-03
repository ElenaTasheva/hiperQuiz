package dao.impl;


import dao.KeyGenerator;
import model.QuizResult;

public class QuizResultRepositoryImpl extends RepositoryMemoryImpl<Long, QuizResult> {

    public QuizResultRepositoryImpl(KeyGenerator<Long> keyGenerator) {
        super(keyGenerator);
    }
}
