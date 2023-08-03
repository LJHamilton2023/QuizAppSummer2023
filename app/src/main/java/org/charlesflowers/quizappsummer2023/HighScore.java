package org.charlesflowers.quizappsummer2023;

public class HighScore {
    private int high_score = 0;

    public HighScore(int score) {
        high_score = score;
    }

    public int getHigh_score() {
        return high_score;
    }

    public void setHigh_score(int high_score) {
        this.high_score = high_score;
    }
}
