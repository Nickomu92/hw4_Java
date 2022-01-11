package com.nikomu_exercise1;

import com.nikomu.Color;

// Класс "Адрес" представляющий одноименную сущность (с несколькими конструкторами)
public class Address {
    // Поле (свойство) представляющее название улицы
    private String name;
    // Поле (свойство) представляющее номер дома
    private int home;

    // Конструктор по-умолчанию
    public Address() {}

    // Конструктор №2
    public Address(String name, int home) {
        this.name = name;
        this.home = home;
    }

    // Метод для получения названия улицы
    public String getName() {
        return this.name;
    }

    // Метод для установки (изменения) значения названия улицы
    public void setName(String name) {
        this.name = name;
    }

    // Метод для получения номера дома
    public int getHome() {
        return this.home;
    }

    // Метод для установки (изменения) значения номера дома
    public void setHome(int home) {
        this.home = home;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "Address {" +
                "name = '" + Color.ANSI_CYAN.getCode() + name + Color.ANSI_RESET.getCode() + '\''  +
                ", home = " + Color.ANSI_BLUE.getCode() + home + Color.ANSI_RESET.getCode() +
                '}';
    }
}
