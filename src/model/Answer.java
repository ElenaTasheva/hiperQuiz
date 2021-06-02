package model;

public class Answer extends BaseEntity<Long, Answer> {

     private Question question; //reference to the Question to which the Answer belongs;
     private String text;// - string 2 - 150 characters long, supporting Markdown syntax;
     private String picture; // (optional) - if the Answer includes picture, valid URL;
     private int score ; //integer number (could be negative too);

    public Answer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
