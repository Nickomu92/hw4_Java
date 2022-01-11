package com.nikomu_exercise2;

// Класс, "инкапсулирующий" в себе вспомогательные методы для предоставления информации (статистики)
public class GameInfo {

    // Метод для получения символа "Гривна"
    public static String getUAH() { return "\u20B4";}

    // Метод для получения символа "Рубль"
    public static String getRUB() {
        return "\u20BD";
    }

    // Метод для получения символа "Евро"
    public static String getEURO() {
        return "\u20AC";
    }

    // Метод для получения символа "Смайлик"
    public static String getSmile() {
        return "\u263A";
    }

    // Метод для получения статистики по игре
    public static void gameStatusInfo(int level) {
        Message.headerMessage(String.format("%-20s", "Уровень"));
        Message.headerMessage(String.format("%20s", "Выигрыш\n"));

        if(level == 15) {
            Message.infoMessage(String.format("%-20s", "\u25B6 15"));
            Message.infoMessage(String.format("%20s\n", "10_000_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.warningMessage(String.format("%-20s", "15"));
            Message.warningMessage(String.format("%20s\n", "10_000_000 \u20B4 (3 несгораемая сумма)"));
        }

        if(level == 14) {
            Message.infoMessage(String.format("%-20s", "\u25B6 14"));
            Message.infoMessage(String.format("%20s\n", "3_000_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "14"));
            Message.whiteMessage(String.format("%20s\n", "3_000_000 \u20B4"));
        }

        if(level == 13) {
            Message.infoMessage(String.format("%-20s", "\u25B6 13"));
            Message.infoMessage(String.format("%20s\n", "1_500_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "13"));
            Message.whiteMessage(String.format("%20s\n", "1_500_000 \u20B4"));
        }

        if(level == 12) {
            Message.infoMessage(String.format("%-20s", "\u25B6 12"));
            Message.infoMessage(String.format("%20s\n", "800_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "12"));
            Message.whiteMessage(String.format("%20s\n", "800_000 \u20B4"));
        }

        if(level == 11) {
            Message.infoMessage(String.format("%-20s", "\u25B6 11"));
            Message.infoMessage(String.format("%20s\n", "400_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "11"));
            Message.whiteMessage(String.format("%20s\n", "400_000 \u20B4"));
        }

        if(level == 10) {
            Message.infoMessage(String.format("%-20s", "\u25B6 10"));
            Message.infoMessage(String.format("%20s\n", "240_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.warningMessage(String.format("%-20s", "10"));
            Message.warningMessage(String.format("%20s\n", "240_000 \u20B4 (2 несгораемая сумма)"));
        }

        if(level == 9) {
            Message.infoMessage(String.format("%-20s", "\u25B6 9"));
            Message.infoMessage(String.format("%20s\n", "120_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "9"));
            Message.whiteMessage(String.format("%20s\n", "120_000 \u20B4"));
        }

        if(level == 8) {
            Message.infoMessage(String.format("%-20s", "\u25B6 8"));
            Message.infoMessage(String.format("%20s\n", "60_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "8"));
            Message.whiteMessage(String.format("%20s\n", "60_000 \u20B4"));
        }

        if(level == 7) {
            Message.infoMessage(String.format("%-20s", "\u25B6 7"));
            Message.infoMessage(String.format("%20s\n", "30_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "7"));
            Message.whiteMessage(String.format("%20s\n", "30_000 \u20B4"));
        }

        if(level == 6) {
            Message.infoMessage(String.format("%-20s", "\u25B6 6"));
            Message.infoMessage(String.format("%20s\n", "15_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "6"));
            Message.whiteMessage(String.format("%20s\n", "15_000 \u20B4"));
        }

        if(level == 5) {
            Message.infoMessage(String.format("%-20s", "\u25B6 5"));
            Message.infoMessage(String.format("%20s\n", "10_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.warningMessage(String.format("%-20s", "5"));
            Message.warningMessage(String.format("%20s\n", "10_000 \u20B4 (1 несгораемая сумма)"));
        }

        if(level == 4) {
            Message.infoMessage(String.format("%-20s", "\u25B6 4"));
            Message.infoMessage(String.format("%20s\n", "5_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "4"));
            Message.whiteMessage(String.format("%20s\n", "5_000 \u20B4"));
        }

        if(level == 3) {
            Message.infoMessage(String.format("%-20s", "\u25B6 3"));
            Message.infoMessage(String.format("%20s\n", "3_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "3"));
            Message.whiteMessage(String.format("%20s\n", "3_000 \u20B4"));
        }

        if(level == 2) {
            Message.infoMessage(String.format("%-20s", "\u25B6 2"));
            Message.infoMessage(String.format("%20s\n", "2_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "2"));
            Message.whiteMessage(String.format("%20s\n", "2_000 \u20B4"));
        }

        if(level == 1) {
            Message.infoMessage(String.format("%-20s", "\u25B6 1"));
            Message.infoMessage(String.format("%20s\n", "1_000 \u20B4 (Ваш выигрыш)"));
        } else {
            Message.whiteMessage(String.format("%-20s", "1"));
            Message.whiteMessage(String.format("%20s\n", "1_000 \u20B4"));
        }

        if(level == 0) {
            Message.warningMessage("\t[message] Вы на 0-м уровне!\n");
        }
    }

    // Метод для получения информации о сумме выигрыша
    public static String getProfitByLevel(int level) {
        String profit = "";
        if(level == 0) {
            profit += "0 ";
        } else if(level == 1) {
            profit += "1_000 ";
        } else if(level == 2) {
            profit += "2_000 ";
        } else if(level == 3) {
            profit += "3_000 ";
        } else if(level == 4) {
            profit += "5_000 ";
        } else if(level == 5) {
            profit += "10_000 ";
        } else if(level == 6) {
            profit += "15_000 ";
        } else if(level == 7) {
            profit += "30_000 ";
        } else if(level == 8) {
            profit += "60_000 ";
        } else if(level == 9) {
            profit += "120_000 ";
        } else if(level == 10) {
            profit += "240_000 ";
        } else if(level == 11) {
            profit += "400_000 ";
        } else if(level == 12) {
            profit += "800_000 ";
        } else if(level == 13) {
            profit += "1_500_000 ";
        } else if(level == 14) {
            profit += "3_000_000 ";
        } else {
            profit += "10_000_000";
        }
        profit += "\u20B4";

        return profit;
    }
}
