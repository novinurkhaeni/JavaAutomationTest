package com.example.testselenium.PageObject;

//import library
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GamePage {
    //variable instance with private access
    private WebDriver driver;

    //GamePage constructor to accept one parameter of type WebDriver called driver
    public GamePage(WebDriver driver) {
        //stores driver parameter references to driver instance variables of the GamePage class
        this.driver = driver;
        //PageFactory to scan for elements declared with annotations like @FindBy in that class
        // and associate them with the appropriate web elements on the page.
        PageFactory.initElements(driver, this);
    }

    // Method to get a specific box element by number
    public WebElement getBox(int number) {
        return driver.findElement(By.xpath("//div[normalize-space()='" + number + "']//span[@class='box']"));
    }
}
