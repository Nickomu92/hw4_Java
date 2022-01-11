/**************************************************************************************************************
 1. Создать метод clone, который будет копировать объект, используя рефлексию. Достаточно простой объект - поля
 String и int.
     * Позаботиться про то, что поля класса могут быть массивами или ArrayList.
    ** Позаботиться про ассоциации(у класса User есть поле Address) - нужна рекурсия.
 **************************************************************************************************************/

package com.nikomu_exercise1;

import com.nikomu_exercise2.Message;
import java.util.ArrayList;
import java.util.List;

// Основной класс для демонстрации функционала решения к Заданию №1
public class Exercise1 {
    // Основной метод класса Exercise1
    public static void main(String[] args) {
        Message.successMessage("\nРезультат работы приложения к первому заданию:\n\n");

        Message.headerMessage("Начальный объект \"Адрес\" №1\n");
        Address address1 = new Address("Соборный", 1);
        System.out.println(address1);
        Address address2 = NikoMuClone.clone(address1);
        Message.warningMessage("\t[message] Создаем клон объекта \"Адрес\" №2 и изменяем название улицы на " +
                "\"Сталеваров\" и номер дома - на 100.\n");
        address2.setName("Сталеваров");
        address2.setHome(100);
        Message.warningMessage("\t[message] Смотрим на клон объекта (\"Адрес\" №2):\n");
        System.out.println(address2);
        Message.warningMessage("\t[message] Смотрим на начальный объект (\"Адрес\" №1):\n");
        System.out.println(address1);


        List<String> companiesNameList = new ArrayList<>();
        companiesNameList.add("Microsoft");
        companiesNameList.add("Apple");
        companiesNameList.add("Google");

        String[] positions = {"Разработчик", "Тестировщик"};

        User user1 = new User("Иван", "Иванов", companiesNameList, positions, address1);

        Message.headerMessage("\n\nНачальный объект \"User\"\n");
        System.out.println(user1);

        Message.warningMessage("\t[message] Создаем клон объекта (\"User\" №2).\n");
        User user2 = NikoMuClone.clone(user1);
        Message.warningMessage("\t[message] Изменим имя на \"Александр\" у клона объекта (\"User\" №2):\n");
        user2.setFirstName("Александр");
        System.out.println(user2);

        Message.warningMessage("\t[message] Изменим адрес у клона объекта (\"User\" №2):\n");
        user2.setAddress(address2);
        System.out.println(user2);

        Message.warningMessage("\t[message] Изменим номер дома у клона объекта (\"User\" №2):\n");
        user2.getAddress().setHome(122);
        System.out.println(user2);
        Message.warningMessage("\t[message] Удалим название 3 компании из списка компаний у клона " +
                "объекта (\"User\" №2):\n");
        user2.getCompanyWorksList().remove(2);
        System.out.println(user2);

        Message.warningMessage("\t[message] Изменим название 2 компании из списка компаний у клона " +
                "объекта (\"User\" №2):\n");
        user2.getCompanyWorksList().set(1, "Facebook");
        System.out.println(user2);

        Message.warningMessage("\t[message] Изменим 1-ю должность из списка компаний у клона " +
                "объекта (\"User\" №2):\n");
        String[] pos = user2.getPositions();
        pos[0] = "Директор";
        user2.setPositions(pos);
        System.out.println(user2);

        Message.warningMessage("\t[message] Смотрим на начальный объект (\"User\" №1):\n");
        System.out.println(user1);


        Message.headerMessage("\n\nНачальный объект \"User\" №3 (используем создание объекта при помощи " +
                "конструктора с другим набором параметров)\n");
        User user3 = new User("Николай", "Николаенко", new Address("Южное шоссе", 1));
        System.out.println(user3);

        Message.warningMessage("\t[message] Создаем клон объекта (\"User\" №4):\n");
        User user4 = NikoMuClone.clone(user3);
        System.out.println(user4);

        Message.warningMessage("\t[message] Изменим клон объекта (\"User\" №4):\n");
        user4.getAddress().setName("Северное шоссе");
        user4.getAddress().setHome(999);
        user4.setFirstName("Светлана");
        System.out.println(user4);

        Message.warningMessage("\t[message] Начальный объект \"User\" №3:\n");
        System.out.println(user3);
    }
}
