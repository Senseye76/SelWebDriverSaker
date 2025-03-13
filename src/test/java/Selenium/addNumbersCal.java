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
import java.util.List;

public class addNumbersCal {


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
        (new WebDriverWait(driver, Duration.ofSeconds(2))).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

        @Test
        public void testListCal() throws InterruptedException {

         driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");
            WebElement popUp = driver.findElement(By.cssSelector(".fc-button-label"));
            popUp.click();


         List< WebElement> elements = driver.findElements(By.className("regfont"));

         for (WebElement e : elements) {
             e.sendKeys("30");

             Thread.sleep(5000);  // Let the user actually see something!
         }
    }
}