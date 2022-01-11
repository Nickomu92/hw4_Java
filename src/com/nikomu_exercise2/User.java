package com.nikomu_exercise2;

// Класс "Пользователь" представляющий одноименную сущность
public class User {
    // Поле (свойство) представляет имя (nick-name) пользователя
    private String name;
    // Поле (свойство) представляет логин пользователя
    private String login;
    // Поле (свойство) представляет пароль пользователя
    private String password;
    // Поле (свойство) представляет максимальный уровень вопроса до которого когда-либо доходил пользователь
    private int recordLevel;
    // Поле (свойство) представляет последний уровень вопроса до которого дошел пользователь
    private int lastLevel;
    // Поле (свойство) является ли пользователь админом
    private boolean isAdmin;

    // Конструктор
    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.recordLevel = 0;
        this.lastLevel = 0;
        this.isAdmin = false;
    }

    // Метод для получения имени пользователя
    public String getName() {
        return this.name;
    }

    // Метод для установки (изменения) имени пользователя
    public void setName(String name) {
        this.name = name;
    }

    // Метод для получения логина пользователя
    public String getLogin() {
        return this.login;
    }

    // Метод для установки (изменения) логина пользователя
    public void setLogin(String login) {
        this.login = login;
    }

    // Метод для получения пароля пользователя
    public String getPassword() {
        return this.password;
    }

    // Метод для установки (изменения) пароля пользователя
    public void setPassword(String password) {
        this.password = password;
    }

    // Метод для получения значения максимального уровня вопроса до которого когда-либо доходил пользователь
    public int getRecordLevel() {
        return this.recordLevel;
    }

    // Метод для установки (изменения) значения максимального уровня вопроса до которого когда-либо
    // доходил пользователь
    public void setRecordLevel(int recordLevel) {
        this.recordLevel = recordLevel;
    }

    // Метод для получения значения последнего уровня вопроса до которого дошел пользователь
    public int getLastLevel() {
        return this.lastLevel;
    }

    // Метод для установки (изменения) значения последнего уровня вопроса до которого дошел пользователь
    public void setLastLevel(int lastLevel) {
        this.lastLevel = lastLevel;
    }

    // Метод для получения значения является ли пользователь админом
    public boolean getAdmin() { return this.isAdmin; }

    // Метод для установки (изменения) значения является ли пользователь админом
    public void setAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "User {" +
                "name = '" + name + '\'' +
                ", login = '" + login + '\'' +
                ", password = '" + password + '\'' +
                ", recordLevel = " + recordLevel +
                ", lastLevel = " + lastLevel +
                "}";
    }
}
