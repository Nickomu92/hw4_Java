package com.nikomu_exercise1;

import com.nikomu.Color;
import java.util.Arrays;
import java.util.List;

// Класс "Пользователь" представляющий одноименную сущность (с несколькими конструкторами)
public class User {
    // Поле (свойство) представляет имя пользователя
    private String firstName;
    // Поле (свойство) представляет фамилию пользователя
    private String lastName;
    // Поле (свойство) представляет список названий компаний, где работал пользователь
    private List<String> companyWorksList;
    // Поле (свойство) представляет должности, которые занимал пользователь
    private String[] positions;
    // Поле (свойство) представляет адрес пользователя
    private Address address;

    // Конструктор по-умолчанию
    public User() {}

    // Конструктор №2
    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Конструктор №3
    public User(String firstName, String lastName, List<String> companyWorksList, String[] positions, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyWorksList = companyWorksList;
        this.positions = positions;
        this.address = address;
    }

    // Конструктор №4
    public User(String firstName, String lastName, List<String> companyWorksList, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyWorksList = companyWorksList;
        this.address = address;
    }

    // Метод для получения имени пользователя
    public String getFirstName() {
        return this.firstName;
    }

    // Метод для установки (изменения) значения имени пользователя
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Метод для получения фамилии пользователя
    public String getLastName() {
        return this.lastName;
    }

    // Метод для установки (изменения) значения фамилии пользователя
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Метод для получения списка компаний, где работал пользователь
    public List<String> getCompanyWorksList() {
        return this.companyWorksList;
    }

    // Метод для установки (изменения) значения списка компаний, где работал пользователь
    public void setCompanyWorksList(List<String> companyWorksList) {
        this.companyWorksList = companyWorksList;
    }

    // Метод для получения списка должностей, которые занимал пользователь
    public String[] getPositions() {
        return this.positions;
    }

    // Метод для установки (изменения) значения списка должностей, которые занимал пользователь
    public void setPositions(String[] positions) {
        this.positions = positions;
    }

    // Метод для получения адреса пользователя
    public Address getAddress() {
        return this.address;
    }

    // Метод для установки (изменения) значения адреса пользователя
    public void setAddress(Address address) {
        this.address = address;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        String outputStr = "User {";
        if(firstName != null) {
            outputStr += "firstName = '" + Color.ANSI_RED.getCode() + this.firstName +
                    Color.ANSI_RESET.getCode() + "\', ";
        }
        if(lastName != null) {
            outputStr += "lastName = '" + Color.ANSI_RED.getCode() + this.lastName +
                    Color.ANSI_RESET.getCode() + "\', ";
        }
        if(companyWorksList != null && companyWorksList.size() > 0) {
            outputStr += "companies = '" + Color.ANSI_RED.getCode() + this.companyWorksList +
                    Color.ANSI_RESET.getCode() + "\', ";
        }
        if(positions != null && positions.length > 0) {
            outputStr +=  "positions = '" + Color.ANSI_RED.getCode() + Arrays.asList(this.positions) +
                    Color.ANSI_RESET.getCode() + "\', ";
        }
        if(address != null) {
            outputStr += "address = '" + this.address + "\'";
        }
        outputStr += "}";

        return outputStr;
    }
}
