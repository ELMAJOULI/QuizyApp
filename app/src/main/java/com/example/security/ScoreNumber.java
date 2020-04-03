package com.example.security;

public  class ScoreNumber {
    private static int scoreNumber = 0 ;

    public static void setScoreNumber(int scoreNumber) {
        ScoreNumber.scoreNumber = scoreNumber;
    }

    public static int getScoreNumber() {
        return scoreNumber;
    }
}
