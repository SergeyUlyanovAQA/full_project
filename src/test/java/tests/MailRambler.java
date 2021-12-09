package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.*;


public class MailRambler {



    @Test
    void authorizationWithUI() {
        open("https://mail.rambler.ru/");
        switchTo().frame($("[src*='id.rambler.ru/login-20']"));
        $("#login").setValue("mailForTesting0");
        $("#password").setValue("mailForTesting0").pressEnter();

    }

}
