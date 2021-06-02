package model;

import java.util.List;

public class Player extends User{

    private List<QuizResult> results;

    // todo transform to Rank enum, using a formula chosen by me
    private int overallScore;
}
