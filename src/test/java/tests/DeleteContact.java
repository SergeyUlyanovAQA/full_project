package tests;

import org.junit.jupiter.api.Test;

public class DeleteContact extends TestBase {

    @Test
    void deleteContact() {
        pageObjects.openMainPage()
                   .authorization()
                   .searchContact()
                   .checkDeleteContact();
    }
}
