package model;

import java.util.List;

public class Question extends BaseEntity<Long, Question> {

    private Quiz quiz; //reference to the Quiz the Question belongs;
    private String text; // - string 10 - 300 characters long, supporting Markdown syntax;
    private String picture; //(optional) - if the Question includes picture, valid URL;
    private List<Answer> answers; //list of Answer entities for the Question;

    public Question() {
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
