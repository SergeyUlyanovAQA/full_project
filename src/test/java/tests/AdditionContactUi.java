package tests;

import org.junit.jupiter.api.Test;

public class AdditionContactUi extends TestBase {

    @Test
    void additionContact() {
        pageObjects.openMainPage()
                .authorization()
                .additionContactExample()
                .parametrsAdditionContact()
                .checkAdditionContact();
    }
}
