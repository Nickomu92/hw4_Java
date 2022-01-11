package com.nikomu_exercise2;

import java.util.ArrayList;
import java.util.List;

// Класс необходимый для создания "случайных" чисел, необходимых для рандомизации вопросов
public class Random {

    // Метод для получения массива очередности ответов
    public static List<Integer> createRandomAnswers() {
        List<Integer> tempArrayList = new ArrayList<>();
        int value;

        do {
            value = randomNumber(0, 3);

            if (!tempArrayList.contains(value)) {
                tempArrayList.add(value);
            }
        } while(tempArrayList.size() < 4);

        return tempArrayList;
    }

    // Метод для получения случайного целого числа в указанном диапазоне
    public static int randomNumber(int start, int end) {
        return (int)(Math.random() * (end - start + 1) + start);
    }
}
