package tests;

import org.junit.jupiter.api.Test;

public class CheckHeader extends TestBase {

    @Test
    void checkHeader() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkResultHeader();
    }
}
