package com.nikomu;

import com.nikomu_exercise1.Exercise1;
import com.nikomu_exercise2.Exercise2;
import com.nikomu_exercise2.GameInfo;
import com.nikomu_exercise2.Message;
import java.util.Scanner;

// Основной (стартовый) класс представляющий "Главное меню"
public class Main {
    // Основной метод класса Main
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String symbol;
        String menu = """
                [1] - Задание №1 (Создание метода clone() с использованием рефлексии);
                [2] - Задание №2 ("Кто хочет стать миллионером");
                [q] - Выход из приложения""";

        do {
            Message.successMessage("\n\tДомашнее задание №4\n");
            Message.errorMessage("\t" + GameInfo.getSmile() + " Мулина Николая " + GameInfo.getSmile() + "\n");
            Message.warningMessage("\tГлавное меню\n");
            System.out.println(menu);
            Message.primaryMessage("Ваш выбор: ");
            symbol = input.nextLine();

            switch(symbol) {
                case "1":
                    Exercise1.main(null);
                    break;

                case "2":
                    Exercise2.main(null);
                    break;

                case "q": case "Q": case "й": case "Й":
                    Message.warningMessage("\n\t[message] Выходим из приложения...\n");
                    return;

                default:
                    Message.errorMessage("\n\t[message] Нет такого пункта меню!\n");
            }
        } while(!symbol.equals("q") && !symbol.equals("Q") && !symbol.equals("й") && !symbol.equals("Й"));
    }
}
