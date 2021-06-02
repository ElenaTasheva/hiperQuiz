package dao.impl;

import dao.QuizRepository;
import model.Quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuizRepositoryImpl extends RepositoryMemoryImpl<Long, Quiz> implements
        QuizRepository {


    @Override
    public List<Quiz> findByDuration(int expectedDuration) {
        return this.findAll()
                .stream().filter(quiz -> quiz.getExpectedDuration() == expectedDuration)
                .collect(Collectors.toList());
    }

    @Override
    public Set<Quiz> findBy(String criteria) {
        Set<Quiz> byTitle = this.findAll().stream().filter(quiz -> quiz.getTitle().equals(criteria))
                .collect(Collectors.toSet());
        //todo check if contains or equals (part of description or all)
        Set<Quiz> byDescription = this.findAll().stream().filter(quiz ->
                quiz.getDescription().contains(criteria))
                .collect(Collectors.toSet());
        Set<Quiz> byTags = this.findAll().stream().filter(quiz ->
                quiz.getTags().contains(criteria))
                .collect(Collectors.toSet());
       return merge(byTitle,byDescription,byTags);

    }

    private static<T> Set<T> merge(Set<T>...sets) {
        return Stream.of(sets)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }


}
