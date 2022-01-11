package com.nikomu_exercise2;

import java.util.List;

// Класс, "инкапсулирующий" в себе вспомогательные методы для авторизации пользователя в игре
public class Authorization {

    // Метод для проверки существует ли в базе приложения пользователь с указанными логином и паролем
    public static User checkAuthorizationData(String login, String password, List<User> users) {

        for (User user: users) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }
}
