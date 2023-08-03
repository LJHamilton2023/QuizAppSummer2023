package org.charlesflowers.quizappsummer2023;

import android.provider.MediaStore;

public class Question {
    private String qPrompt;
    private boolean correctAnswer;
    //records whether or not answered correctly
    private boolean answered = false;
    //records number of overall, total, attempts
    //answering all of the questions
    private static int attempts;

    private int pic;

    //private MediaStore.Images.ImageColumns

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

    public static int getAttempts() {
        return attempts;
    }

    public static void setAttempts(int attempts) {
        Question.attempts = attempts;
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

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
