package pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageObjects {
    private final String START_PAGE = "https://mail.rambler.ru/";
    private final String LOGIN = "mailForTesting0@rambler.ru";
    private final String PASSWORD = "mailForTesting0";
    private final String LOGINNULL = "null@rambler.ru";
    private final String PASSWORDNULL = "null";

    Faker faker = new Faker();

    String email = faker.internet().emailAddress();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();


    @Step ("Открытие страницы авторизации")
    public PageObjects openMainPage () {
        open(START_PAGE);

        return this;
    }
    @Step ("Вход под учетными данными")
    public PageObjects authorization () {
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue(LOGIN);
        $("#password").setValue(PASSWORD).pressEnter();

        return this;
    }
    @Step ("Проверка успешной авторизации")
    public PageObjects checkAuthorization () {
        $(".rui__1E3a7").shouldHave(text(LOGIN));

        return this;
    }
    @Step ("Проверка безуспешной авторизации")
    public PageObjects checkNotAuthorization () {
        $(".rui-Button-content").shouldHave(text("Восстановить"));

        return this;
    }
    @Step ("Вход под некорректными учетными данными")
    public PageObjects authorizationNull () {
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue(LOGINNULL);
        $("#password").setValue(PASSWORDNULL).pressEnter();

        return this;
    }
    @Step ("Выход из аккаунта")
    public PageObjects logout () {
        $(".rui__2FTrL").click();
        $(byText("Выйти")).click();

        return this;
    }
    @Step ("Проверка выхода из аккаунта")
    public PageObjects checkLogout () {
        $(".rui__xXIS_").shouldHave(text("Войти в почту"));

        return this;
    }
    @Step ("Создание и отправка сообщения")
    public PageObjects sendMassege () {
        $(".rui-Button-content").click();
        $("#receivers").setValue("mailForTesting0@rambler.ru");
        $(byText("Отправить")).click();

        return this;
    }
    @Step ("Поиск сообщения и его удаление")
    public PageObjects deleteMessageExample () {
        $(byText("Входящие")).click();
        $(byText("(нет темы)")).click();
        $(".rui-Tooltip-anchor").click();

        return this;
    }
    @Step ("Проверка отправленного сообщения")
    public PageObjects checkSendMassege () {
        $(".SentLetter-head-1P").shouldHave(text("Письмо отправлено"));

        return this;
    }
    @Step ("Проверка удаленного сообщения")
    public PageObjects checkDeleteMassege () {
        $(".notification-message").shouldHave(text("Письмо перемещено в папку «Корзина»"));

        return this;
    }
    @Step ("Проверка главного меню")
    public PageObjects checkResultHeader () {
        $(".rui__1HMZk").shouldHave(text("Почта"),
                text("Новости"),
                text("Кино"),
                text("Спорт"),
                text("Авто"),
                text("Шоу-бизнес"),
                text("Гороскопы"),
                text("Финансы"),
                text("Еще"));

        return this;
    }
    @Step ("Открытие формы добавления нового контакта")
    public PageObjects additionContactExample () {
        $(".tour__contacts-button").click();
        $(byText("ДОБАВИТЬ КОНТАКТ")).click();

        return this;
    }
    @Step ("Ввод данных нового контакта и его сохранение")
    public PageObjects parametrsAdditionContact () {
        $("[name='email']").setValue(email);
        $("[name='last_name']").setValue(firstName);
        $("[name='first_name']").setValue(lastName);
        $("[name='cell_phone']").setValue("+71234567890");
        $("[name='work']").setValue("NBA");
        $("[name='birthday']").setValue("17.02.1963");
        $(byText("Сохранить")).click();

        return this;
    }
    @Step ("Проверка добавленного контакта")
    public PageObjects checkAdditionContact () {
        $(".Contacts-wrapper-2z").shouldHave(text(firstName + " " + lastName));
        $(".Contacts-wrapper-2z").shouldHave(text(email));

        return this;
    }
    @Step ("Поиск контакта и его удаление")
    public PageObjects searchContact () {
        $(".tour__contacts-button").click();
        $(".Checkbox-root-vD").click();
        $("[data-contacts-toolbar='delete-contacts']").click();

        return this;
    }
    @Step ("Проверка удаленного контакта")
    public PageObjects checkDeleteContact () {
        $(".notifications-tr").shouldHave(text("Контакт удален"));

        return this;
    }
}
