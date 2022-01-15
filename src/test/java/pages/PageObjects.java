package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageObjects {

    private final String LOGIN = "mailForTesting0@rambler.ru";
    private final String PASSWORD = "mailForTesting0";
    private final String LOGINNULL = "null@rambler.ru";
    private final String PASSWORDNULL = "null";

    public PageObjects openMainPage () {
        open("https://mail.rambler.ru/");

        return this;
    }

    public PageObjects authorization () {
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue(LOGIN);
        $("#password").setValue(PASSWORD).pressEnter();

        return this;
    }

    public PageObjects checkAuthorization () {
        $(".rui__1E3a7").shouldHave(text("mailfortesting0@rambler.ru"));

        return this;
    }

    public PageObjects checkNotAuthorization () {
        $(".rui-Button-content").shouldHave(text("Восстановить"));

        return this;
    }

    public PageObjects authorizationNull () {
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue(LOGINNULL);
        $("#password").setValue(PASSWORDNULL).pressEnter();

        return this;
    }

    public PageObjects logout () {
        $(".rui__2FTrL").click();
        $(byText("Выйти")).click();

        return this;
    }

    public PageObjects checkLogout () {
        $(".rui__xXIS_").shouldHave(text("Войти в почту"));

        return this;
    }

    public PageObjects sendMassege () {
        $(".rui-Button-content").click();
        $("#receivers").setValue("mailForTesting0@rambler.ru");
        $(byText("Отправить")).click();

        return this;
    }

    public PageObjects deleteMessageExample () {
        $(byText("Входящие")).click();
        $(byText("(нет темы)")).click();
        $(".rui-Tooltip-anchor").click();

        return this;
    }

    public PageObjects checkSendMassege () {
        $(".SentLetter-head-1P").shouldHave(text("Письмо отправлено"));

        return this;
    }

    public PageObjects checkDeleteMassege () {
        $(".notification-message").shouldHave(text("Письмо перемещено в папку «Корзина»"));

        return this;
    }

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

    public PageObjects additionContactExample () {
        $(".tour__contacts-button").click();
        $(byText("ДОБАВИТЬ КОНТАКТ")).click();

        return this;
    }

    public PageObjects parametrsAdditionContact () {
        $("[name='email']").setValue("mailForTesting1@rambler.ru");
        $("[name='last_name']").setValue("Jordan");
        $("[name='first_name']").setValue("Michael");
        $("[name='cell_phone']").setValue("+71234567890");
        $("[name='work']").setValue("NBA");
        $("[name='birthday']").setValue("17.02.1963");
        $(byText("Сохранить")).click();

        return this;
    }

    public PageObjects checkAdditionContact () {
        $(".Contacts-wrapper-2z").shouldHave(text("Jordan Michael"));
        $(".Contacts-wrapper-2z").shouldHave(text("mailfortesting1@rambler.ru"));

        return this;
    }

    public PageObjects searchContact () {
        $(".tour__contacts-button").click();
        $(".Checkbox-root-vD").click();
        $("[data-contacts-toolbar='delete-contacts']").click();

        return this;
    }

    public PageObjects checkDeleteContact () {
        $(".notifications-tr").shouldHave(text("Контакт удален"));

        return this;
    }
}
