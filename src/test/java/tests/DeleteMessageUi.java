package tests;

import org.junit.jupiter.api.Test;

public class DeleteMessageUi extends TestBase {

    @Test
    void deleteMessage() {
        pageObjects.openMainPage()
                .authorization()
                .deleteMessageExample()
                .checkDeleteMassege();
    }
}
