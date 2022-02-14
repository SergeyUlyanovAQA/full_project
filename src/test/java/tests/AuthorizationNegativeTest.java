package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class AuthorizationNegativeTest extends TestBase {

    @Test
    void negativeTestAuthorization() {
        pageObjects.openMainPage()
                   .authorizationNull()
                   .checkNotAuthorization();
    }
}
