package Selenium;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testBoardGameGeek {

    @Test
    public void testBoardGame() throws InterruptedException {
      WebDriver driver = new ChromeDriver();
      driver.get("https://boardgamegeek.com/");



    }
}