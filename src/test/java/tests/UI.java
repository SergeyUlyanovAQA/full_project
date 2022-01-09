package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class UI extends TestBase {


    @Test
    void pozitiveTestAuthorization() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkAuthorization();
    }

    @Test
    void negativeTestAuthorization() {
        pageObjects.openMainPage();
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("null@rambler.ru");
        $("#password").setValue("null").pressEnter();
        $(".rui-Button-content").shouldHave(text("Восстановить"));
    }

    @Test
    void exitFromMail() {
        pageObjects.openMainPage()
                   .authorization()
                   .logout()
                   .checkLogout();
    }

    @Test
    void sendingSimpleLetter() {
        pageObjects.openMainPage()
                   .authorization()
                   .sendMassege()
                   .checkSendMassege();
    }

    @Test
    void deleteMessage() {
        pageObjects.openMainPage()
                   .authorization();
        $(byText("Входящие")).click();
        $(byText("(нет темы)")).click();
        $(".rui-Tooltip-anchor").click();
        $(".notification-message").shouldHave(text("Письмо перемещено в папку «Корзина»"));
    }

    @Test
    void checkHeader() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkResultHeader();
    }

    @Test
    void additionContact() {
        pageObjects.openMainPage()
                   .authorization();
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
        pageObjects.openMainPage()
                   .authorization();
        $(".tour__contacts-button").click();
        $(".Checkbox-root-vD").click();
        $("[data-contacts-toolbar='delete-contacts']").click();
        $(".notifications-tr").shouldHave(text("Контакт удален"));
    }

}
