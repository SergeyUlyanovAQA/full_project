package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageObjects {

    private final String LOGIN = "mailForTesting0@rambler.ru";
    private final String PASSWORD = "mailForTesting0";

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

    public PageObjects checkSendMassege () {
        $(".SentLetter-head-1P").shouldHave(text("Письмо отправлено"));

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
}
