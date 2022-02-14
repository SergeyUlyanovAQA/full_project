package tests;

import org.junit.jupiter.api.Test;

public class SendingSimpleLetter extends TestBase {

    @Test
    void sendingSimpleLetter() {
        pageObjects.openMainPage()
                   .authorization()
                   .sendMassege()
                   .checkSendMassege();
    }
}
