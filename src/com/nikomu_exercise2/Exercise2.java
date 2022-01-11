/***********************************************************************************************************
 2. Консольная игра "Кто хочет стать миллионером".
 Вопросы хранить в файле в формате через точку с запятой.

 Пример:23
 Вопрос;правильный ответ;неправильный ответ1;неправильный ответ2;неправильный ответ3;
 Подготовить 10 вопросов.

 При выходе из игры происходит сохранение, на каком вопросе пользователь оставновился.

 **Подготовить разные уровни сложности игры
 ***********************************************************************************************************/

package com.nikomu_exercise2;

import java.io.File;
import java.util.*;

// Основной класс для демонстрации функционала решения к Заданию №2
public class Exercise2 {

    private static List<Question> questionsList;
    private static List<User> usersList;
    private static List<List<Question>> questionsByLevelList;
    private static User currentUser = null;
    private static final String usersFilePath = "users.json";
    private static final String questionsFilePath = "questions.json";
    private static boolean isAuth = false;

    // Основной метод класса Exercise2
    public static void main(String[] args) {

        // В самом начале необходимо получить список пользователей, чтобы можно было проверять
        // существует ли пользователь или ему необходимо зарегистрироваться

        File usersFile = new File(usersFilePath);

        // Если файл "users.json" существует, то
        if(usersFile.exists()) {
            // Считываем данные из файла
            getUsersList();
        } else {
            // Создаем файл, записываем в него данные и считываем их
            makeUsersList(CreateUsersList.getUsersList());
        }

        // Метод представляющий игру
        playGame();
    }

    // Метод представляющий игру
    public static void playGame() {
        if(authorization()) {
            File questionsFile = new File(questionsFilePath);

            // Если файл "questions.json" существует, то
            if(questionsFile.exists()) {
                // Считываем данные из файла
                getQuestionsList();
            } else {
                // Создаем файл, записываем в него данные и считываем их
                makeQuestionsList(CreateQuestionsList.getQuestionsList());
            }

            separatingQuestionsByLevel();
            gameMenu();
        }
    }

    // Метод для авторизации в игре
    public static boolean authorization() {
        Scanner input = new Scanner(System.in);
        String symb;
        String menu = """
                [a] - Авторизоваться (у меня уже есть учетная запись);
                [r] - Зарегистрироваться (у меня еще нет учетной записи); 
                [q] - Выйти из игры.""";
        boolean isContinue = false;

        Message.headerMessage("\n\t" + GameInfo.getRUB() + GameInfo.getUAH() + GameInfo.getEURO() +
                " Приветствуем Вас в игре \"Кто хочет стать миллионером\" " +
                GameInfo.getEURO() + GameInfo.getUAH() + GameInfo.getRUB() + "\n");

        do {
            Message.warningMessage("\n\t[message] Для продолжения необходимо авторизоваться!\n");
            Message.primaryMessage("\n\tВозможные варианты для выбора:\n");
            System.out.println(menu);
            Message.primaryMessage("Ваш выбор: ");
            symb = input.nextLine();
            System.out.println();

            switch(symb) {
                case "a": case "A": case "ф": case "Ф":
                    Message.headerMessage("\tАвторизация:\n");
                    currentUser = logIn();

                    if(currentUser != null) {
                        Message.infoMessage("\n\tПриветствуем, " + currentUser.getName() + "!\n");
                    } else {
                        Message.errorMessage("\n\t[message] Неверный логин или пароль!\n");
                    }

                    isContinue = true;
                    break;

                case "r": case "R": case "к": case "К":
                    Message.headerMessage("\tРегистрация:\n");
                    registration();
                    isContinue = true;
                    break;

                case "q": case "Q": case "й": case "Й":
                    Message.warningMessage("\t[message] Выход из игры \"Кто хочет стать миллионером\"...\n");
                    isContinue = false;
                    break;

                default:
                    Message.errorMessage("\t[message] Нет такого пункта меню!\n");
            }

        } while((!symb.equals("q") && !symb.equals("Q") && !symb.equals("й") &&
                !symb.equals("Й")) && currentUser == null);

        return isContinue;
    }

    // Метод для входа под своей учетной записью
    public static User logIn() {
        String login = Verification.checkInputStringData("Введите логин: ",
                "\n\t[message] Логин должен состоять из минимум 4 символов!\n", 4);
        String password = Verification.checkInputStringData("Введите пароль: ",
                "\n\t[message] Пароль должен состоять из минимум 4 символов!\n", 4);

        return Authorization.checkAuthorizationData(login, password, usersList);
    }

    // Метод для регистрации нового пользователя
    public static void registration() {
        String name = Verification.checkInputStringData("Введите имя (nick-name): ",
                "\n\t[message] Имя (Nick-name) должно состоять из минимум 1 символа!\n", 1);
        String login = Verification.checkInputStringData("Введите логин: ",
                "\n\t[message] Логин должен состоять из минимум 4 символов!\n", 4);
        String password = Verification.checkInputStringData("Введите пароль: ",
                "\n\t[message] Пароль должен состоять из минимум 4 символов!\n", 4);

        User newUser = new User(name, login, password);

        List<User> currentUsersList = new ArrayList<>(usersList);
        currentUsersList.add(newUser);

        makeUsersList(currentUsersList);
    }

    // Метод отображения игрового меню в зависимости от типа пользователя
    public static void gameMenu() {
        Scanner input = new Scanner(System.in);
        String symb;
        boolean isContinue = false;
        String userMenu = """
                [1] - Играть;
                [2] - Посмотреть статистику по текущей игре; 
                [q] - Выйти из игры.""";
        String adminMenu = """
                [1] - Создать новый вопрос;
                [q] - Выйти из игры.""";

        do {
            Message.primaryMessage("\n\tВозможные варианты для выбора:\n");
            if(currentUser.getAdmin()) {
                System.out.println(adminMenu);
            } else {
                System.out.println(userMenu);
            }

            Message.primaryMessage("Ваш выбор: ");
            symb = input.nextLine();
            System.out.println();

            if(currentUser.getAdmin() && symb.equals("1")) {
                makeNewQuestion();
            } else if(!currentUser.getAdmin() && symb.equals("1")) {
                isContinue = showQuestion(currentUser.getLastLevel());

                if(!isContinue) {
                    return;
                }
            } else if(!currentUser.getAdmin() && symb.equals("2")) {
                GameInfo.gameStatusInfo(currentUser.getLastLevel());
            } else if(symb.equals("q") || symb.equals("Q") || symb.equals("й") || symb.equals("Й")) {
                checkProfit(false);
                Message.warningMessage("\n\t[message] Выход из игры \"Кто хочет стать миллионером\"...\n");
                return;
            } else {
                Message.errorMessage("\n\t[message] Нет такого варианта!\n\n");
            }
        } while(currentUser.getLastLevel() < 15 || !isContinue);

        if(currentUser.getLastLevel() == 15) {
            currentUser.setLastLevel(0);
            usersList.get(usersList.indexOf(currentUser)).setLastLevel(currentUser.getLastLevel());
            JsonSerializer.serializeUsers(usersList, usersFilePath);
        }
    }

    // Метод компоновки и отображения вопроса
    public static boolean showQuestion(int level) {
        if(level < 15) {
            // Создаем список номеров ответов в случайном порядке
            List<Integer> randomAnswersList = Random.createRandomAnswers();

            // Создаем текущий вопрос
            Question currentQuestion;

            // Если в списке вопросов, разделенных по уровням есть только один вопрос данного уровня сложности,
            // то присваиваем его значение текущему вопросу
            if(questionsByLevelList.get(level).size() < 2) {
                currentQuestion = questionsByLevelList.get(level).get(0);
            }
            // иначе присваиваем текущему вопросу любой (случайный) вопрос, который соответствует данному уровню сложности
            else {
                int questionLevelNumb = Random.randomNumber(0, questionsByLevelList.get(level).size() - 1);
                currentQuestion = questionsByLevelList.get(level).get(questionLevelNumb);
            }

            Message.infoMessage(String.format("\n%d. %s\n", currentUser.getLastLevel() + 1, currentQuestion.getQuestion()));
            System.out.printf("\t[A]. %-20s", currentQuestion.getAnswers()[randomAnswersList.get(0)]);
            System.out.printf("\t\t[B]. %-20s\n", currentQuestion.getAnswers()[randomAnswersList.get(1)]);
            System.out.printf("\t[C]. %-20s", currentQuestion.getAnswers()[randomAnswersList.get(2)]);
            System.out.printf("\t\t[D]. %-20s\n", currentQuestion.getAnswers()[randomAnswersList.get(3)]);
            System.out.printf("\t[Q]. Закончить игру\n");

            int resultNumber = selectAnswer();

            if(resultNumber >= 0 && resultNumber <= 3) {
                return checkAnswer(currentQuestion.getAnswers()[randomAnswersList.get(resultNumber)],
                        currentQuestion.getCorrectAnswer());
            }
        }

        return false;
    }

    // Метод для проверки введенного пользователем ответа
    public static boolean checkAnswer(String answer, String correctAnswer) {
        Message.warningMessage("\n\t[message] Ваш ответ - " + answer + ", и это... ");

        // Немного "спим" (2 секунды)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        if(answer.equals(correctAnswer)) {
            Message.successMessage("правильный ответ!\n");
            checkUserLevel(true);

            usersList.get(usersList.indexOf(currentUser)).setLastLevel(currentUser.getLastLevel());
            JsonSerializer.serializeUsers(usersList, usersFilePath);

            return true;
        } else {
            Message.errorMessage("неправильный ответ!");
            Message.warningMessage(" Правильный ответ - " + correctAnswer + "!\n");
            checkUserLevel(false);

            usersList.get(usersList.indexOf(currentUser)).setLastLevel(currentUser.getLastLevel());
            JsonSerializer.serializeUsers(usersList, usersFilePath);

            return false;
        }
    }

    // Метод для проверки на котором уровне сложности вопроса находится пользователь
    public static void checkUserLevel(boolean level) {
        if(level) {
            currentUser.setLastLevel(currentUser.getLastLevel() + 1);
            checkProfit(true);

            if(currentUser.getLastLevel() > currentUser.getRecordLevel()) {
                currentUser.setRecordLevel(currentUser.getLastLevel());
            }
        } else {
            checkProfit(false);
            currentUser.setLastLevel(0);
        }
    }

    // Метод для проверки суммы выигрыша
    public static void checkProfit(boolean isContinue) {
       if(!currentUser.getAdmin()) {
           if(isContinue) {
               Message.successMessage(String.format("\n\t[message] Ваш выигрыш составил - %s!\n",
                       GameInfo.getProfitByLevel(currentUser.getLastLevel())));
               if(currentUser.getLastLevel() == 15) {
                   Message.successMessage("\n\t[message] Поздравляем Вы стали чемпионом игры \"Кто хочет стать " +
                           "миллионером\"!!!\n");
               }
           } else {
               if(currentUser.getLastLevel() >= 10) {
                   Message.warningMessage(String.format("\n\t[message] Ваш выигрыш составил - %s!\n",
                           GameInfo.getProfitByLevel(10)));
               } else if(currentUser.getLastLevel() >= 5) {
                   Message.warningMessage(String.format("\n\t[message] Ваш выигрыш составил - %s!\n",
                           GameInfo.getProfitByLevel(5)));
               } else if(currentUser.getLastLevel() < 5) {
                   Message.warningMessage(String.format("\n\t[message] Ваш выигрыш составил - %s!\n",
                           GameInfo.getProfitByLevel(0)));
               }
           }
       }
    }

    public static int selectAnswer() {
        Scanner input = new Scanner(System.in);
        String symbol;

        do {
            Message.primaryMessage("Ваш выбор: ");
            symbol = input.nextLine();

            switch(symbol) {
                case "A": case "a": case "ф": case "Ф":
                    return 0;

                case "b": case "B": case "и": case "И":
                    return 1;

                case "c": case "C": case "с": case "С":
                    return 2;

                case "d": case "D": case "в": case "В":
                   return 3;

                case "q": case "Q": case "й": case "Й":
                    Message.warningMessage("\n\t[message] Выходим из игры \"Кто хочет стать миллионером\"...\n");
                    return 4;

                default:
                    Message.errorMessage("\n\t[message] Нет такого варианта!\n\n");
            }
        } while (true);
    }

    public static void makeQuestionsList(List<Question> currentQuestionList) {
        if(questionsList == null || currentQuestionList.size() > questionsList.size()) {
            if(JsonSerializer.serializeQuestions(currentQuestionList, questionsFilePath)) {
                Message.successMessage("\n\t[message] Сохранение списка вопросов в файл выполнено успешно!\n");
                getQuestionsList();
            } else  {
                Message.errorMessage("\n\t[message] Ошибка сохранения списка вопросов в файл!\n");
            }
        }
    }

    public static void getQuestionsList() {
        questionsList = JsonDeserializer.deserializeQuestions(questionsFilePath);

        if(questionsList.size() > 0) {
            Message.successMessage("\n\t[message] Чтение списка вопросов из файла выполнено успешно!\n");
        } else {
            Message.errorMessage("\n\t[message] Ошибка чтения списка вопросов из файла!\n");
        }
    }

    public static void makeUsersList(List<User> currentUsersList) {
        if(usersList == null || currentUsersList.size() > usersList.size()) {
            if (JsonSerializer.serializeUsers(currentUsersList, usersFilePath)) {
                Message.successMessage("\n\t[message] Сохранение списка пользователей в файл выполнено успешно!\n");
                getUsersList();
            } else {
                Message.errorMessage("\n\t[message] Ошибка сохранения списка пользователей в файл!\n");
            }
        }
    }

    public static void getUsersList() {
        usersList = JsonDeserializer.deserializeUsers(usersFilePath);

        if (usersList.size() > 0) {
            Message.successMessage("\n\t[message] Чтение списка пользователей из файла выполнено успешно!\n");
        } else {
            Message.errorMessage("\n\t[message] Ошибка чтения списка пользователей из файла!\n");
        }
    }

    public static void separatingQuestionsByLevel() {
        questionsByLevelList = new ArrayList<>();

        List<Question> questionLevel1 = new ArrayList<>();
        List<Question> questionLevel2 = new ArrayList<>();
        List<Question> questionLevel3 = new ArrayList<>();
        List<Question> questionLevel4 = new ArrayList<>();
        List<Question> questionLevel5 = new ArrayList<>();
        List<Question> questionLevel6 = new ArrayList<>();
        List<Question> questionLevel7 = new ArrayList<>();
        List<Question> questionLevel8 = new ArrayList<>();
        List<Question> questionLevel9 = new ArrayList<>();
        List<Question> questionLevel10 = new ArrayList<>();
        List<Question> questionLevel11 = new ArrayList<>();
        List<Question> questionLevel12 = new ArrayList<>();
        List<Question> questionLevel13 = new ArrayList<>();
        List<Question> questionLevel14 = new ArrayList<>();
        List<Question> questionLevel15 = new ArrayList<>();

        for(Question question : questionsList) {
            if(question.getQuestionLevel() == 1) {
                questionLevel1.add(question);
            } else if(question.getQuestionLevel() == 2) {
                questionLevel2.add(question);
            } else if(question.getQuestionLevel() == 3) {
                questionLevel3.add(question);
            } else if(question.getQuestionLevel() == 4) {
                questionLevel4.add(question);
            } else if(question.getQuestionLevel() == 5) {
                questionLevel5.add(question);
            } else if(question.getQuestionLevel() == 6) {
                questionLevel6.add(question);
            } else if(question.getQuestionLevel() == 7) {
                questionLevel7.add(question);
            } else if(question.getQuestionLevel() == 8) {
                questionLevel8.add(question);
            } else if(question.getQuestionLevel() == 9) {
                questionLevel9.add(question);
            } else if(question.getQuestionLevel() == 10) {
                questionLevel10.add(question);
            } else if(question.getQuestionLevel() == 11) {
                questionLevel11.add(question);
            } else if(question.getQuestionLevel() == 12) {
                questionLevel12.add(question);
            } else if(question.getQuestionLevel() == 13) {
                questionLevel13.add(question);
            } else if(question.getQuestionLevel() == 14) {
                questionLevel14.add(question);
            } else if(question.getQuestionLevel() == 15) {
                questionLevel15.add(question);
            }
        }

        questionsByLevelList.add(questionLevel1);
        questionsByLevelList.add(questionLevel2);
        questionsByLevelList.add(questionLevel3);
        questionsByLevelList.add(questionLevel4);
        questionsByLevelList.add(questionLevel5);
        questionsByLevelList.add(questionLevel6);
        questionsByLevelList.add(questionLevel7);
        questionsByLevelList.add(questionLevel8);
        questionsByLevelList.add(questionLevel9);
        questionsByLevelList.add(questionLevel10);
        questionsByLevelList.add(questionLevel11);
        questionsByLevelList.add(questionLevel12);
        questionsByLevelList.add(questionLevel13);
        questionsByLevelList.add(questionLevel14);
        questionsByLevelList.add(questionLevel15);
    }

    public static void makeNewQuestion() {
        Message.headerMessage("\n\tСоздание вопроса\n");

        String question = Verification.checkInputStringData("Введите вопрос: ",
                "Вопрос должен состоять минимум из 10 символов", 10);

        String[] answers = new String[4];

        answers[0] = Verification.checkInputStringData("Введите вариант ответа №1: ",
                "[message] Ответ должен состоять минимум из 1 символа", 1);

        answers[1] = Verification.checkInputStringData("Введите вариант ответа №2: ",
                "[message] Ответ должен состоять минимум из 1 символа", 1);

        answers[2]= Verification.checkInputStringData("Введите вариант ответа №3: ",
                "[message] Ответ должен состоять минимум из 1 символа", 1);

        answers[3] = Verification.checkInputStringData("Введите вариант ответа №4: ",
                "[message] Ответ должен состоять минимум из 1 символа", 1);

        String correctAnswer = Verification.checkInputStringData("Введите правильный вариант ответа на вопрос: ",
                "[message] Ответ должен состоять минимум из 1 символа", 1);

        int questionLevel = Verification.checkInputIntData("Укажите уровень сложности вопроса (1...15): ",
                "[message] Уровень сложности вопроса должен быть от 1 до 15");

        Question newQuestion = new Question(question, answers, correctAnswer, questionLevel);

        questionsList.add(newQuestion);

        JsonSerializer.serializeQuestions(questionsList, questionsFilePath);
    }
}
