package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PageObjects;

public class TestBase {

    PageObjects pageObjects = new PageObjects();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
}
