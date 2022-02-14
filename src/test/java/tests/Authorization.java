package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class Authorization extends TestBase {

    @Test
    void Authorization() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkAuthorization();
    }
}
