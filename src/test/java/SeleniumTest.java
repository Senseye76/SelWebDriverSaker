import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void  testFullFlow () {
        testSearchLaptop();
        testLogIn();
        testAddToCart();

    }

    public void testSearchLaptop() {
        driver.get("https://demowebshop.tricentis.com/");

        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        List<WebElement> searchResults = driver.findElements(By.cssSelector(".product-title a"));
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }

        if (searchResults.isEmpty()) {
            System.out.println("Inga sökresultat hittades!");
        } else {
            System.out.println("Testet lyckades! Produkten hittades.");
        }

    }

    public void testLogIn() {
        driver.get("https://demowebshop.tricentis.com/login");


        WebElement hittaEpost = driver.findElement(By.id("Email"));
        WebElement hittaLosen = driver.findElement(By.id("Password"));
        WebElement knappLogin = driver.findElement(By.cssSelector("input.login-button"));

        hittaEpost.sendKeys("kinojoker12@gmail.com");
        hittaLosen.sendKeys("Selina76323232");
        knappLogin.click();

        WebElement logut = driver.findElement(By.linkText("Log out"));
        assert logut.isDisplayed() : "Inloggning misslyckades!";
        System.out.println("Testet lyckades! Användaren är inloggad.");

    }

    public void testAddToCart() {
       driver.get("https://demowebshop.tricentis.com/search?q=Laptop");
        //driver.get("https://demowebshop.tricentis.com/cart");

        //WebElement produkt1 = driver.findElement(By.cssSelector(".product-box-add-to-cart-button"));
        //produkt1.click();

        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector(".product-box-add-to-cart-button"));
        if (addToCartButtons.isEmpty()) {
            System.out.println("Ingen produkt hittades i sökresultatet!");
            return;
        }
        addToCartButtons.get(0).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".cart-qty"), "(1)"));

        driver.findElement(By.linkText("Shopping cart")).click();

        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-item-row")));
        assert cartItem.isDisplayed() : "Produkten finns inte i varukorgen!";
        System.out.println("Testet lyckades! Produkten lades till i varukorgen.");
    }
}