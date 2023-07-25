package org.charlesflowers.quizappsummer2023;

public class Question {
    private String qPrompt;
    private boolean correctAnswer;

    public Question(String qPrompt) {
        this.qPrompt = qPrompt;
    }

    public Question(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Question(String qPrompt, boolean correctAnswer) {
        this.qPrompt = qPrompt;
        this.correctAnswer = correctAnswer;
    }

    public Question() {
    }

    public String getqPrompt() {
        return qPrompt;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setqPrompt(String qPrompt) {
        this.qPrompt = qPrompt;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qPrompt='" + qPrompt + '\'' +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}