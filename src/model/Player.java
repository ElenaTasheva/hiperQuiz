package model;

import model.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class Player extends User{

    // todo transform to Rank enum, using a formula chosen by me, only getter
    private List<QuizResult> results;
    private int overallScore;
    private Rank rank;

    public Player() {
        this.results = new ArrayList<>();
    }



}
