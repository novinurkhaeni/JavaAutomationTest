package com.example.testselenium.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    //mendeklarasikan locator dari elemen web yang akan kita pakai
    @FindBy(xpath = "//input[contains(@type, 'text')]")
    // variabel global instansi
    // variabel untuk mendeklarasikan locator atasnya
    // WebElement merupakan instance dari selenium
    public WebElement inputUsername;
    @FindBy(xpath = "//input[contains(@type, 'password')]")
    public WebElement inputPassword;
    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    public WebElement loginButton;

    // method atau function untuk menginisiasi dalam 1 class,
    // agar class LoginPage dapat dapat dipanggil di class lain
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
