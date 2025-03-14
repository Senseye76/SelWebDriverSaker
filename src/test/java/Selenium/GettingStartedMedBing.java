package Selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GettingStartedMedBing {

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
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
        @Test
        public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.bing.com/");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            By acceptCookiesButton = By.cssSelector("button#bnp_btn_accept");
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();

        } catch (Exception e) {
            System.out.println("Cookies popup hittades inte, eller den är redan accepterad.");
        }
        //  WebElement popUp = driver.findElement(By.xpath("/html/body/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div"));
        //  popUp.click();
            Thread.sleep(2000);  // Let the user actually see something!

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea#sb_form_q")));

        //  WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));

            searchBox.sendKeys("Testing duckduckgo");

            searchBox.submit();

            Thread.sleep(2000);  // Let the user actually see something!


        }

    }
