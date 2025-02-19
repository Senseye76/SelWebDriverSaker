package Selenium;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;

import org.junit.Test;

public class GettingStarted {

    @Test

    public void testGoogleSearch() throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");

        Thread.sleep(5000);  // Let the user actually see something!

        WebElement searchBox = driver.findElement(By.id("#inputWrapper"));

        searchBox.sendKeys("ChromeDriver");

        searchBox.submit();

        Thread.sleep(5000);  // Let the user actually see something!

        driver.quit();

    }

}
