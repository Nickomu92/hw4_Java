package com.nikomu_exercise2;

import java.util.*;

// Класс, "инкапсулирующий" в себе методы для создания сущностей "Вопрос"
public class CreateQuestionsList {

    // Метод для создания списка вопросов
    public static List<Question> getQuestionsList() {
        Question question1 = new Question(
                "Какой рыболовной снастью ловил рыбу старик из сказки А.С. Пушкина Сказка о рыбаке и рыбке?",
                new String[] {"Неводом", "Удочкой", "Бреднем", "Сачком"},
                "Неводом", 1
        );

        Question question2 = new Question(
                "Где муха-цокотуха нашла денежку?",
                new String[] {"На лугу", "В лесу", "Во дворе", "В поле"},
                "В поле", 2
        );

        Question question3 = new Question(
                "Где жил старик со своею старухой из сказки А.С. Пушкина Сказка о рыбаке и рыбке?",
                new String[] {"В землянке", "В избушке", "В лачужке", "В шалаше"},
                "В землянке", 3
        );

        Question question4 = new Question(
                "От какого дерева появляются желуди?",
                new String[] {"Клен", "Дуб", "Ясень", "Каштан"},
                "Дуб", 4
        );

        Question question5 = new Question(
                "Чем промышлял Дуремар из сказки Золотой ключик?",
                new String[] {"Пиявками", "Лягушками", "Бабочками", "Стрекозами"},
                "Пиявками", 5
        );

        Question question6 = new Question(
                "Какая из этих рек впадает в Азовское море?",
                new String[] {"Днепр", "Дон", "Южный Буг", "Днестр"},
                "Дон", 6
        );

        Question question7 = new Question(
                "Как называется детеныш норки?",
                new String[] {"Щенок", "Котенок", "Белек", "Норик"},
                "Щенок", 7
        );

        Question question8 = new Question(
                "Как звали крысу в сказке Золотой ключик?",
                new String[] {"Шушара", "Чучундра", "Мымра", "Шуршелла"},
                "Шушара", 8
        );

        Question question9 = new Question(
                "У автомобилей какой из этих стран международный регистрационный знак DZ?",
                new String[] {"Белиз", "Замбия", "Алжир",  "Бенин"},
                "Алжир", 9
        );

        Question question10 = new Question(
                "Кто получил первую Нобелевскую премию по литературе?",
                new String[] {"Поэт", "Романист", "Драматург", "Эссеист"},
                "Поэт", 10
        );

        Question question11 = new Question(
                "В честь какого растения область Фриули-Венеция-Джулия в Италии ежегодно проводит трёхмесячный фестиваль?",
                new String[] {"Лук", "Спаржа", "Фасоль", "Артишок"},
                "Спаржа", 11
        );

        Question question12 = new Question(
                "В каком городе в 1932 году был проведён первый международный кинофестиваль?",
                new String[] {"Венеция", "Канн", "Париж", "Берлин"},
                "Венеция", 12
        );

        Question question13 = new Question(
                "Как в народе называют химическое соединение - тринитротолуол?",
                new String[] {"Тротил", "Пластид", "Гексаген", "Динамит"},
                "Тротил", 13
        );

        Question question14 = new Question(
                "Чему равна сумма чисел от 0 до 100 включительно?",
                new String[] {"5050", "3525", "1000", "7550"},
                "5050", 14
        );

        Question question15 = new Question(
                "Кто из президентов США написал свой собственный рассказ про Шерлока Холмса?",
                new String[] {"Джон Кеннеди", "Рональд Рейган", "Франклин Рузвельт", "Ричард Никсон"},
                "Франклин Рузвельт", 15
        );

        List<Question> questionsList = new ArrayList<>();

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        questionsList.add(question11);
        questionsList.add(question12);
        questionsList.add(question13);
        questionsList.add(question14);
        questionsList.add(question15);

        return questionsList;
    }
}
