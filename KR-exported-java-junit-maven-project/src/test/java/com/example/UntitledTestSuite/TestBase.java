package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.Entities.AccountData;
import com.example.UntitledTestSuite.Entities.ProductData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class TestBase {
    protected WebDriver driver;


    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    protected void deleteAllProduct() {
        driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/button")).click();
    }

    protected void changeQuantity(Integer quantity) {
        driver.get("https://kazanexpress.ru/cart");
        WebElement quantityField = driver.findElement(
                By.xpath("/html/body/div/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[5]/div/div/input")
        );
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity.toString());
    }

    protected void addProductToCart(ProductData product) {
        driver.get(product.getLink());
        driver.findElement(By.xpath("//div[@id='product-info']/div[2]/div[2]/div/div[2]/div/div/div/div[2]")).click();
        driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[5]/div/div/div[1]/button")).click();
        driver.findElement(By.id("cart-button")).click();
    }


    protected void login(AccountData data) throws InterruptedException {
        driver.findElement(By.xpath("//main[@id='main-page']/div/header/div/div/div[3]/a/i")).click();
        WebElement phoneInput = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/div[1]/div/input"));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(data.getUsername());
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/div[2]/div/input"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(data.getPassword());
        WebElement signIN = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/button"));
        signIN.click();
    }

    protected void openHomePage() {
        driver.get("https://kazanexpress.ru/#");
    }

    @Before
    public void setUp() throws Exception {
//    System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
    }
}