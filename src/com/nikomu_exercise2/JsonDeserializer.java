package com.nikomu_exercise2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

// Класс для десериализации текстовых данных и чтения их из файла
public class JsonDeserializer {

    // Метод для получения списка вопросов из JSON-строки
    public static List<Question> getQuestionsList(String jsonStr) {
        Type arrayListType = new TypeToken<ArrayList<Question>>(){}.getType();
        List<Question> tempQuestionsList = new Gson().fromJson(jsonStr, arrayListType);
        return tempQuestionsList;
    }

    // Метод для получения списка пользователей из JSON-строки
    public static List<User> getUsersList(String jsonStr) {
        Type arrayListType = new TypeToken<ArrayList<User>>(){}.getType();
        List<User> tempUsersList = new Gson().fromJson(jsonStr, arrayListType);
        return tempUsersList;
    }

    // Метод для чтения (десериализации) данных из файла в JSON-строку
    public static String deserialize(String filePath) {
        String tempJsonString = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String strLine = "";
            while((strLine = reader.readLine()) != null) {
                tempJsonString += strLine + "\n";
            }
        }
        catch(IOException ex) {
            Message.errorMessage(ex.getMessage());
        }
        finally {
            return tempJsonString;
        }
    }

    public static List<Question> deserializeQuestions(String filePath) {
        String jsonString = JsonDeserializer.deserialize(filePath);
        List<Question> tempQuestionsList = JsonDeserializer.getQuestionsList(jsonString);
        return tempQuestionsList;
    }

    public static List<User> deserializeUsers(String filePath) {
        String jsonString = JsonDeserializer.deserialize(filePath);
        List<User> tempUsersList = JsonDeserializer.getUsersList(jsonString);
        return tempUsersList;
    }
}
