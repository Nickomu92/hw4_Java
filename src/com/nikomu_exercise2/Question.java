package com.nikomu_exercise2;

import java.util.Arrays;

// Класс "Вопрос" представляющий одноименную сущность
public class Question {
    // Поле, которое представляет вопрос
    private String question;
    // Поле, которое представляет массив ответов
    private String[] answers;
    // Поле, которое представляет правильный ответ
    private String correctAnswer;
    // Поле, которое представляет уровень сложности вопроса
    private int questionLevel;

    // Конструктор
    public Question(String question, String[] answers, String correctAnswer, int questionLevel) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.questionLevel = questionLevel;
    }

    // Метод для получения вопроса
    public String getQuestion() {
        return question;
    }

    // Метод для установки (изменения) значения вопроса
    public void setQuestion(String question) {
        this.question = question;
    }

    // Метод для получения массива ответов
    public String[] getAnswers() {
        return answers;
    }

    // Метод для уставки (изменения) массива ответов
    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    // Метод для получения правильного ответа
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Метод для установки (изменения) значения правильного ответа
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    // Метод для получения уровня вопроса
    public int getQuestionLevel() {
        return questionLevel;
    }

    // Метод для установки (изменения) значения уровня вопроса
    public void setQuestionLevel(int questionLevel) {
        this.questionLevel = questionLevel;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", questionLevel=" + questionLevel +
                '}';
    }
}
