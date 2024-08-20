package com.example.testselenium.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAccountPage {
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/nav/div[1]/div[2]/div[2]/div[1]")
    public WebElement manageAccountButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/nav/div[1]/div[2]/div[2]/div[1]/div[2]/i")
    public WebElement dropDownButton;
    @FindBy(xpath = "//div[contains(text(),'List User')]")
    public WebElement listUserMenu;
    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    public WebElement createAccountButton;

    //create user
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/span[1]/div/div/div[1]/div/input")
    public WebElement inputName;
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/div[1]/span[1]/div/div/div[1]/div[1]/div[1]/input")
    public WebElement selectGender;
    @FindBy(xpath = "//div[contains(text(),'MALE')]")
    public WebElement maleOption;
    @FindBy(xpath = "//div[contains(text(),'FEMALE')]")
    public WebElement femaleOption;
    @FindBy(xpath = "//input[contains(@placeholder,'Pilih jenis akun')]")
    public WebElement selectRole;
    @FindBy(xpath = "//div/div[3]/div/div[1]/div/div[contains(text(),'ROLE_USER')]")
    public WebElement userOption;
    @FindBy(xpath = "//div/div[3]/div/div[1]/div/div[contains(text(),'ROLE_SELEB')]")
    public WebElement selebOption;
    @FindBy(xpath = "//div/div[3]/div/div[1]/div/div[contains(text(),'ROLE_INITIATOR')]")
    public WebElement initiatorOption;
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/span[2]/div/div/div[1]/div/input")
    public WebElement inputUsername;
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/span[3]/div/div/div[1]/div/input")
    public WebElement inputPassword;
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/input")
    public WebElement confirmPassword;
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/span[4]/div/div/div[1]/div/input")
    public WebElement inputEmail;
    @FindBy(xpath = "//span/form/div[1]/div[2]/div[1]/span[5]/div/div/div[1]/div/input")
    public WebElement inputPhone;
    @FindBy(xpath = "//span[contains(text(),'Simpan')]")
    public WebElement saveButton;

    @FindBy(xpath = "//td[contains(text(),'jiminmochi')]")
    public WebElement dataUsername;

    public ManageAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
