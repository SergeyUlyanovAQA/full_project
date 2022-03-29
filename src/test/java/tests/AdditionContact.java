package tests;

import org.junit.jupiter.api.Test;

public class AdditionContact extends TestBase {

    @Test
    void additionContact() {
        pageObjects.openMainPage()
                   .authorization()
                   .additionContactExample()
                   .parametrsAdditionContact()
                   .checkAdditionContact();
    }
}
