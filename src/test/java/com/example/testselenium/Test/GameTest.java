package com.example.testselenium.Test;

import com.example.testselenium.PageObject.GamePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GameTest {
    private WebDriver driver;
    private GamePage gamePage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver with options
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();  // Maximize the browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // Set implicit wait time
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Initialize WebDriverWait
        driver.get("https://zzzscore.com/1to50/en/");  // Open the game page
        gamePage = new GamePage(driver);  // Initialize GamePage with WebDriver
    }

    @AfterEach
    public void tearDown() {
        driver.quit();  // Close the browser after each test
    }

    @Test
    public void findNumber() {
        for (int i = 1; i <= 50; i++) {
            // Get the specific box element using the method from GamePage
            WebElement box = wait.until(ExpectedConditions.elementToBeClickable(gamePage.getBox(i)));
            if (box != null) {
                box.click();  // Click the box if it is not null
            }
            // Wait for new elements to load if necessary
            try {
                Thread.sleep(1000);  // Sleep for 1 second to allow new elements to appear
            } catch (InterruptedException e) {
                e.printStackTrace();  // Print stack trace if interrupted
            }
        }
    }
}
