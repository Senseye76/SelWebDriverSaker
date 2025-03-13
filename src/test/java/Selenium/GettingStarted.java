package Selenium;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class GettingStarted {

    @Test

    public void testGoogleSearch() throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://duckduckgo.com/");

        Thread.sleep(2000);  // Let the user actually see something!

        WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));

        searchBox.sendKeys("Testing duckduckgo");

        searchBox.submit();

        Thread.sleep(2000);  // Let the user actually see something!

        driver.quit();

    }

}
