package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends BaseEntity<Long, Quiz> {

    //todo add method to add questions
    private String title; // string 2 to 80 characters long
    // todo check if only Admin can create quiz
    private User author; // the User that created the Quiz;
    private String description; //string 20 - 250 characters long, supporting Markdown syntax;
    private List<Question> questions  = new ArrayList<>(); // list of Question entities (containing the answers with their scores too);
    private int expectedDuration; // integer number in minutes;
    private String URL; //picture (optional) - best representing the Quiz, valid URL to a picture, if missing a placeholder picture should be used;
    private String tags; //string including comma separated tags, allowing to find the Quizes by quick search;


    public Quiz() {

    }

    public Quiz(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(int expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quiz{");
        sb.append("created=").append(getCreated());
        sb.append(", id=").append(getId());
        sb.append(", title='").append(title).append('\'');
        sb.append(", author=").append(author);
        sb.append(", description='").append(description).append('\'');
        sb.append(", questions=").append(questions);
        sb.append(", expectedDuration=").append(expectedDuration);
        sb.append(", URL='").append(URL).append('\'');
        sb.append(", tags='").append(tags).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void addQuestion(Question question){
        questions.add(question);
    }



}
