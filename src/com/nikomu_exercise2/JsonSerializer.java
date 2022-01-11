package com.nikomu_exercise2;

import com.google.gson.*;
import java.io.*;
import java.util.List;

// Класс для сериализации текстовых данных и записи их файл
public class JsonSerializer {

    // Метод для создания JSON-строки из списка вопросов
    public static String makeJsonQuestionsString(List<Question> dataList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(dataList);
        return jsonStr;
    }

    // Метод для создания JSON-строки из списка пользователей
    public static String makeJsonUsersString(List<User> dataList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonStr = gson.toJson(dataList);
        return jsonStr;
    }

    // Метод для записи (сериализации) данных в файл
    public static boolean serialize(String data, String filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
            return true;
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // Метод для записи (сериализации) списка вопросов в файл
    public static boolean serializeQuestions(List<Question> questionsList, String filePath) {
        String jsonQuestionsStr = JsonSerializer.makeJsonQuestionsString(questionsList);

        if(JsonSerializer.serialize(jsonQuestionsStr, filePath)) {
            return true;
        } else {
            return false;
        }
    }

    // Метод для записи (сериализации) списка пользователей в файл
    public static boolean serializeUsers(List<User> usersList, String filePath) {
        String jsonUsersStr = JsonSerializer.makeJsonUsersString(usersList);

        if(JsonSerializer.serialize(jsonUsersStr, filePath)) {
            return true;
        } else {
            return false;
        }
    }
}
