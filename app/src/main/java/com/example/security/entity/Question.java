package com.example.security.entity;

public class Question {

    private int idQuestion;
    private Boolean answer;

    public Question(int idQuestion, Boolean answer) {
        this.idQuestion = idQuestion;
        this.answer = answer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
