package tests;

import org.junit.jupiter.api.Test;

public class ExitFromMail extends TestBase {

    @Test
    void exitFromMail() {
        pageObjects.openMainPage()
                   .authorization()
                   .logout()
                   .checkLogout();
    }
}
