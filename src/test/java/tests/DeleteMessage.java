package tests;

import org.junit.jupiter.api.Test;

public class DeleteMessage extends TestBase {

    @Test
    void deleteMessage() {
        pageObjects.openMainPage()
                   .authorization()
                   .deleteMessageExample()
                   .checkDeleteMassege();
    }
}
