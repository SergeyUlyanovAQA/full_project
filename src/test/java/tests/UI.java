package tests;

import org.junit.jupiter.api.Test;


public class UI extends TestBase {


    @Test
    void pozitiveTestAuthorization() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkAuthorization();
    }

    @Test
    void negativeTestAuthorization() {
        pageObjects.openMainPage()
                   .authorizationNull()
                   .checkNotAuthorization();
    }

    @Test
    void exitFromMail() {
        pageObjects.openMainPage()
                   .authorization()
                   .logout()
                   .checkLogout();
    }

    @Test
    void sendingSimpleLetter() {
        pageObjects.openMainPage()
                   .authorization()
                   .sendMassege()
                   .checkSendMassege();
    }

    @Test
    void deleteMessage() {
        pageObjects.openMainPage()
                   .authorization()
                   .deleteMessageExample()
                   .checkDeleteMassege();
    }

    @Test
    void checkHeader() {
        pageObjects.openMainPage()
                   .authorization()
                   .checkResultHeader();
    }

    @Test
    void additionContact() {
        pageObjects.openMainPage()
                   .authorization()
                   .additionContactExample()
                   .parametrsAdditionContact()
                   .checkAdditionContact();
    }

    @Test
    void deleteContact() {
        pageObjects.openMainPage()
                   .authorization()
                   .searchContact()
                   .checkDeleteContact();
    }

}
