package tests;

import org.junit.jupiter.api.Test;

public class AuthorizationUi extends TestBase {

    @Test
    void Authorization() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkAuthorization();
    }
}
