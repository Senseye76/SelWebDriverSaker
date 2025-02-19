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

public class egetTestMedNyHemsida {

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
    public void testCal2() throws InterruptedException {
        driver.get("https://web2.0calc.com/");
        WebElement popUp = driver.findElement(By.cssSelector(".fc-button-label"));
        popUp.click();
        Thread.sleep(2000);  // Let the user actually see something!

        driver.findElement(By.cssSelector("button[id='Btn9']")).click();

        for (int i = 0; i < 100; i++) {
            driver.findElement(By.cssSelector("button[id='Btn0']")).click();
        }

        driver.findElement(By.cssSelector("button[id='BtnMult']")).click();

        for (int i = 0; i < 100; i++) {
            driver.findElement(By.cssSelector("button[id='Btn9']")).click();
        }

        driver.findElement(By.cssSelector("button[id='BtnCalc']")).click();



        WebElement result = driver.findElement(By.id("input"));
        String resultText = result.getAttribute("value");
        System.out.println("Beräkningsresultat: " + resultText);
    }
}