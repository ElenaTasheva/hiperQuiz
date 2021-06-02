package model;

import java.util.List;

public class Administrator extends User {
    List<Quiz> quizzesBlocked;

    public Administrator() {
    }

    public List<Quiz> getQuizzesBlocked() {
        return quizzesBlocked;
    }

    public void setQuizzesBlocked(List<Quiz> quizzesBlocked) {
        this.quizzesBlocked = quizzesBlocked;
    }
}
