package com.example.testselenium.Test;

import com.example.testselenium.PageObject.ManageAccountPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CreateAccountTest extends LoginTest {
    private ManageAccountPage manageAccountPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        manageAccountPage = new ManageAccountPage(driver);

        // Now call the login method
        login("administrator", "Mabes132");
    }

    //@Test is a jUnit annotation that marks a method as a test case.
    @Test
    public void createAccount() throws InterruptedException {
        // Navigate to create account page
        manageAccountPage.manageAccountButton.click();
        Thread.sleep(3000);
        manageAccountPage.dropDownButton.click();
        Thread.sleep(3000);
        manageAccountPage.listUserMenu.click();
        Thread.sleep(3000);
        manageAccountPage.createAccountButton.click();
        Thread.sleep(3000);

        // Input data for new user account
        manageAccountPage.inputName.sendKeys("Park Jimin");
        manageAccountPage.selectGender.click();
        manageAccountPage.maleOption.click();
        manageAccountPage.selectRole.click();
        manageAccountPage.userOption.click();
        manageAccountPage.inputUsername.sendKeys("jiminmochi");
        manageAccountPage.inputPassword.sendKeys("Mabes132");
        manageAccountPage.confirmPassword.sendKeys("Mabes132");
        manageAccountPage.inputEmail.sendKeys("parkjimin@mail.com");
        manageAccountPage.inputPhone.sendKeys("0832938347838");
        manageAccountPage.saveButton.click();
        Thread.sleep(10000);

        // findText
        // Get the text from the element
        String actualText = manageAccountPage.dataUsername.getText();

        // Expected text
        String expectedText = "jiminmochi";

        // Assert that the actual text matches the expected text
        assertEquals(expectedText, actualText, "Text does not match!");

        // Print the text to the console (optional)
        System.out.println("Found text: " + actualText);
    }
}
