package tests;

import com.codeborne.selenide.Selenide;
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
