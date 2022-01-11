package com.nikomu_exercise2;

import java.util.*;

// Класс, "инкапсулирующий" в себе методы для начального создания сущностей "Пользователь"
public class CreateUsersList {

    // Метод для начального (стартового) создания пользователей
    public static List<User> getUsersList() {
        User admin = new User("Шеф", "admin", "1111");
        admin.setAdmin(true);
        User user1 = new User("Игрок 1", "user1", "1111");

        List<User> tempUsersList = new ArrayList<>();
        tempUsersList.add(admin);
        tempUsersList.add(user1);

        return tempUsersList;
    }
}
