package model;

import model.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class Player extends User {

    private List<QuizResult> results = new ArrayList<>();
    private int overallScore;
    private Rank rank;

    public Player(String username) {
        super(username);
    }




    public int getOverallScore() {
        for (QuizResult result : results) {
            this.overallScore += result.getScore();
        }
        return overallScore;
    }

    public Rank getRank() {
        if (overallScore < 50) {
            rank = Rank.JUNIOR;
        } else if (overallScore > 50 && overallScore < 100) {
            rank = Rank.MID;
        } else {
            rank = Rank.MASTER;
        }
        return rank;
    }


}