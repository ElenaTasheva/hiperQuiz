package dao.impl;

import dao.KeyGenerator;
import dao.QuizRepository;
import dao.UserRepository;
import model.Quiz;
import model.User;

public class UserRepositoryImpl extends RepositoryMemoryImpl<Long, User> implements
        UserRepository {

        public UserRepositoryImpl(KeyGenerator<Long> keyGenerator) {
                super(keyGenerator);
        }
}
