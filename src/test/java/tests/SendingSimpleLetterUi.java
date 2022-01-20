package tests;

import org.junit.jupiter.api.Test;

public class SendingSimpleLetterUi extends TestBase {

    @Test
    void sendingSimpleLetter() {
        pageObjects.openMainPage()
                .authorization()
                .sendMassege()
                .checkSendMassege();
    }
}
