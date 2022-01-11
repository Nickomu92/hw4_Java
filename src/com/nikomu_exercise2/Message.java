package com.nikomu_exercise2;

import com.nikomu.Color;

// Класс, "инкапсулирующий" методы для предоставления разных по цвету сообщений
public class Message {
    public static void warningMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_YELLOW.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void errorMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_RED.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void primaryMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_CYAN.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void successMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_GREEN.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void infoMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_BLUE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void headerMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_PURPLE.getCode(), message, Color.ANSI_RESET.getCode());
    }

    public static void whiteMessage(String message) {
        System.out.printf("%s%s%s", Color.ANSI_WHITE.getCode(), message, Color.ANSI_RESET.getCode());
    }
}
