package Selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import static org.junit.Assert.assertEquals;


public class egettest {

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
        public void testCal() throws InterruptedException {
            driver.get("https://web2.0calc.com/");
            WebElement popUp = driver.findElement(By.cssSelector(".fc-button-label"));
            popUp.click();
            Thread.sleep(2000);  // Let the user actually see something!

            driver.findElement(By.cssSelector("button[id='Btn5']")).click();
            driver.findElement(By.cssSelector("button[id='BtnPlus']")).click();
            driver.findElement(By.cssSelector("button[id='Btn5']")).click();
            driver.findElement(By.cssSelector("button[id='BtnCalc']")).click();
            Thread.sleep(2000);  // Let the user actually see something!

            //WebElement answer =
            WebElement answer = driver.findElement(By.id("input"));
            String actual = answer.getAttribute("value");
            String expected = "10";

           assertEquals(expected,actual);



        }
}
