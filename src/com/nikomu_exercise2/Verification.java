package com.nikomu_exercise2;

import java.util.Scanner;

// Класс представляющий собой "Верификатор" данных
public class Verification {

    // Метод проверки ввода строковых данных
    public static String checkInputStringData(String message, String errorMessage, int size) {
        Scanner input = new Scanner(System.in);
        String tempString;

        do {
            Message.primaryMessage(message);
            tempString = input.nextLine();

            if(tempString.length() < size) {
                Message.warningMessage(String.format("\t%s\n", errorMessage));
            }
        } while(tempString.length() < size);

        return tempString;
    }

    // Метод проверки ввода целочисленных данных
    public static int checkInputIntData(String message, String errorMessage) {
        Scanner input = new Scanner(System.in);
        String tempString;
        int tempInt;

        do {
            Message.primaryMessage(message);
            tempString = input.nextLine();

            if((tempInt = isLevel(tempString)) == -1) {
                Message.warningMessage(String.format("\t%s!\n", errorMessage));
            }
        } while(isLevel(tempString) == -1);
        return tempInt;
    }

    // Метод проверки ввода уровня сложности вопроса
    public static int isLevel(String number) {
        try {
            int tempNumber = Integer.parseInt(number);
            if(tempNumber >= 1 && tempNumber <= 15) {
                return tempNumber;
            } else {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
