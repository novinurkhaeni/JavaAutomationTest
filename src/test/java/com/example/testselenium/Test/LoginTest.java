package com.example.testselenium.Test;

import com.example.testselenium.PageObject.LoginPage;
import com.example.testselenium.PageObject.ManageAccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {
    //create variable instansi
    //WebDriver adalah instance dari selenium
    //WebDriver aalah child dari WebElement
    //WebElement adalah parent dari WebDriver
    protected WebDriver driver;
    protected LoginPage loginPage;

    //@BeforeEach is an annotation from jUnit that is used to indicate that the method below must be executed first
    @BeforeEach
    public void setUp() {
        //untuk membuka web browser
        ChromeOptions options = new ChromeOptions();
        //menginisiasi variabel driver mengambil perintah dari ChromeDriver
        driver = new ChromeDriver(options);
        //driver sudah memiliki identitas dari ChromeDriver
        //untuk mengatur besar/kecilnya ukuran layar
        driver.manage().window().maximize();
        //digunakan untuk mengatur kecepatan load page dari url yang dipanggil
        //delay 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //digunakan untuk mengmbil value url
        driver.get("https://test-mok.kipaskipas.com/auth");
        //untuk memanggil value/locator di class LoginPage/package PageObject
        loginPage = new LoginPage(driver);
    }


    //@AfterEach is a jUnit annotation that marks the method below to be executed last
    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    protected void login(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        loginPage.loginButton.click();
    }

}
