package tests;

import org.junit.jupiter.api.Test;

public class AuthorizationNegativeTestUi extends TestBase {

    @Test
    void negativeTestAuthorization() {
        pageObjects.openMainPage()
                   .authorizationNull()
                   .checkNotAuthorization();
    }
}
