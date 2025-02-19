package Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class maxaHemsidan {
    private WebDriver driver;

    @Before
    public void setDriver() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void popUp(WebDriver driver, By by) {
        (new WebDriverWait(driver, Duration.ofSeconds(5))).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();

    }

    @Test
    public void testCalInfinite() throws InterruptedException {

        for (int i = 1; i <= 10; i++)
        driver.get("https://web2.0calc.com/");

        WebElement popUp = driver.findElement(By.cssSelector(".fc-button-label"));
        popUp.click();


        Thread.sleep(3000);

        System.out.println(" Klar!");
    }
}