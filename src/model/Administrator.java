package model;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    List<Quiz> quizzesBlocked = new ArrayList<>();

    public Administrator() {
        this.quizzesBlocked = new ArrayList<>();
    }

    public List<Quiz> getQuizzesBlocked() {
        return quizzesBlocked;
    }

    public void setQuizzesBlocked(List<Quiz> quizzesBlocked) {
        this.quizzesBlocked = quizzesBlocked;
    }
}
