package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MailRambler {

    @Test
    void authorizationWithUI () {
        open("https://mail.rambler.ru/");
        $("#login").setValue("mailForTesting0");
        $("#password").setValue("mailForTesting0").pressEnter();


    }

}
