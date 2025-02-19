package Selenium;

//Övning – Flöde
//
//        Navigera till sidan: https://demowebshop.tricentis.com/
//        Använd sökfunktionen för att söka efter en produkt.
// Kontrollera att sökresultaten innehåller produkten du sökte efter genom att hämta titlarna på resultaten och jämföra med söktermen.


import org.openqa.selenium.*;

import org.openqa.selenium.chrome.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tricentis {

//    @Test
//    public void testGoogleSearch1() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demowebshop.tricentis.com/");
//        //Thread.sleep(5000);  // Let the user actually see something!
//        WebElement shoppingCartLink = driver.findElement(By.className("cart-label"));
//        String shoppingCartLinkatText = shoppingCartLink.getText();
//        assertEquals("Shopping cart", shoppingCartLinkatText);


    @Test
    public void flow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Build your own expensive computer");
      //  searchBox.submit();
        WebElement searchButton = driver.findElement(By.className("button-1 search-box-button"));



//  String shoppingCartLinkatText = shoppingCartLink.getText();
//   assertEquals("Shopping cart",shoppingCartLinkatText);
    }
}