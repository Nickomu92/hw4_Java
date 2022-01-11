package com.nikomu_exercise1;

import com.nikomu_exercise2.Message;
import java.lang.reflect.*;
import java.util.*;

// Класс со статическими методами для полного (глубокого) копирования (клонирования) объекта
public class NikoMuClone {
    public static <T> T clone(T obj) {
            // Копия (клон) объекта
            T tempClone;

            // Получаем список (массив) конструкторов объекта
            Constructor[] constructors = obj.getClass().getConstructors();

            int count = constructors.length - 1;

            // Выбираем подходящий конструктор (при наличии нескольких конструкторов в классе)
            // для создания копии объекта
            do {
                // Получим список параметров конструктора
                Parameter[] parameters = constructors[count--].getParameters();
                // Пытаемся создать точную копию объекта при помощи разных конструкторов (при наличии в классе
                // нескольких конструкторов). Начинаем "перебирать конструкторы" начиная с последних.
                tempClone = getClone(obj, parameters);
            } while(tempClone == null || count > 0);

            return tempClone;
    }

    // Метод для получения копии объекта соответствующей количеству параметров конструктора
    public static <T> T getClone(T obj, Parameter[] parameters) {
        try {
            // Получим список (массив) типов параметров конструктора
            Class[] classTypeParams = new Class[parameters.length];

            // Получим список (массив) аргументов параметров конструктора
            Object[] classObjects = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                classTypeParams[i] = getClassType(parameters[i].getType().getName());
            }

            // Получим список (массив) полей (свойств) объекта
            Field[] fields = obj.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);

                // Если поле (свойство) не инициализировано или является константой, то
                if(fields[i].get(obj) == null
                        || Modifier.isFinal(fields[i].getModifiers())) {
                    // Пропускаем итерацию
                    continue;
                }

                // Если поле (свойство) представляет один из примитивных типов, ссылочную класс-обертку
                // примитивного типа или строку
                if(fields[i].getType().isPrimitive()
                        || fields[i].getType().equals(boolean.class)
                        || fields[i].getType().equals(byte.class)
                        || fields[i].getType().equals(short.class)
                        || fields[i].getType().equals(int.class)
                        || fields[i].getType().equals(long.class)
                        || fields[i].getType().equals(float.class)
                        || fields[i].getType().equals(double.class)
                        || fields[i].getType().equals(Boolean.class)
                        || fields[i].getType().equals(Byte.class)
                        || fields[i].getType().equals(Short.class)
                        || fields[i].getType().equals(Integer.class)
                        || fields[i].getType().equals(Long.class)
                        || fields[i].getType().equals(Float.class)
                        || fields[i].getType().equals(Double.class)
                        || fields[i].getType().equals(String.class)) {
                    // Добавляем в массив (список) аргументов для параметров конструктора значение поля (свойства)
                    classObjects[i] = fields[i].get(obj);
                }
                // Если поле (свойство) представляет список List или ArrayList
                else if(fields[i].getGenericType().getTypeName().contains("java.util.List") ||
                        fields[i].getGenericType().getTypeName().contains("java.util.ArrayList")) {
                    // Добавляем в массив (список) аргументов для параметров конструктора копию списка
                    // List или ArrayList
                    classObjects[i] = new ArrayList<>((List)fields[i].get(obj));
                }
                // Если поле (свойство) представляет массив
                else if(fields[i].getType().isArray()) {
                    // Получим массив
                    Object array = fields[i].get(obj);

                    // Получим размер массива
                    int length = Array.getLength(array);

                    // Создадим копию массива
                    Object copyArray = Array.newInstance(array.getClass().getComponentType(), length);

                    // Скопируем содержимое массивов
                    for (int j = 0; j < length; j++) {
                        Array.set(copyArray, j, Array.get(array, j));
                    }
                    // Добавляем в массив (список) аргументов для параметров конструктора копию массива
                    classObjects[i] = copyArray;
                }
                // Иначе
                else {
                    // Рекурсивно получим объект и добавим его в массив (список) аргументов для параметров
                    // конструктора
                    classObjects[i] = NikoMuClone.clone(fields[i].get(obj));
                }
            }

            // Создаем копию объекта
            T clone = (T)obj.getClass().getConstructor(classTypeParams).newInstance(classObjects);
            return clone;
        } catch(Exception e){
            return null;
        }
    }

    // Метод для получения типа (класса) объекта
    public static Class getClassType(String strType) {
        if (strType.equals("boolean")) {
            return boolean.class;
        } else if (strType.equals("byte")) {
            return byte.class;
        } else if (strType.equals("short")) {
            return short.class;
        } else if (strType.equals("int")) {
            return int.class;
        } else if (strType.equals("long")) {
            return long.class;
        } else if (strType.equals("float")) {
            return float.class;
        } else if (strType.equals("double")) {
            return double.class;
        } else if (strType.equals("char")) {
            return char.class;
        } else {
            try {
                return Class.forName(strType);
            } catch (ClassNotFoundException e) {
                Message.errorMessage("[error] " + e.getMessage() + "\n");
                return null;
            }
        }
    }
}
