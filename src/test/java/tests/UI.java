package tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class UI extends TestBase {


    @Test
    void pozitiveTestAuthorization() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(".rui__1E3a7").shouldHave(text("mailfortesting0@rambler.ru"));
    }

    @Test
    void negativeTestAuthorization() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("null@rambler.ru");
        $("#password").setValue("null").pressEnter();
        $(".rui-Button-content").shouldHave(text("Восстановить"));
    }

    @Test
    void exitFromMail() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(".rui__2FTrL").click();
        $(byText("Выйти")).click();
        $(".rui__xXIS_").shouldHave(text("Войти в почту"));
    }

    @Test
    void sendingSimpleLetter() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(".rui-Button-content").click(); // перекрывает элемент
        $("#receivers").setValue("mailForTesting0@rambler.ru");
        $(byText("Отправить")).click();
        $(".SentLetter-head-1P").shouldHave(text("Письмо отправлено"));
    }

    @Test
    void deleteMessage() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(byText("Входящие")).click();
        $(byText("(нет темы)")).click();
        $(".rui-Tooltip-anchor").click();
        $(".notification-message").shouldHave(text("Письмо перемещено в папку «Корзина»"));
    }

    @Test
    void checkHeader() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(".rui__1HMZk").shouldHave(text("Почта"),
                text("Новости"),
                text("Кино"),
                text("Спорт"),
                text("Авто"),
                text("Шоу-бизнес"),
                text("Гороскопы"),
                text("Финансы"),
                text("Еще"));
    }

    @Test
    void additionContact() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(".tour__contacts-button").click();
        $(byText("ДОБАВИТЬ КОНТАКТ")).click();
        $("[name='email']").setValue("mailForTesting1@rambler.ru");
        $("[name='last_name']").setValue("Jordan");
        $("[name='first_name']").setValue("Michael");
        $("[name='cell_phone']").setValue("+71234567890");
        $("[name='work']").setValue("NBA");
        $("[name='birthday']").setValue("17.02.1963");
        $(byText("Сохранить")).click();
        $(".Contacts-wrapper-2z").shouldHave(text("Jordan Michael"));
        $(".Contacts-wrapper-2z").shouldHave(text("mailfortesting1@rambler.ru"));
    }

    @Test
    void deleteContact() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0@rambler.ru");
        $("#password").setValue("mailForTesting0").pressEnter();
        $(".tour__contacts-button").click();
        $(".Checkbox-root-vD").click();
        $("[data-contacts-toolbar='delete-contacts']").click();
        $(".notifications-tr").shouldHave(text("Контакт удален"));
    }

}
