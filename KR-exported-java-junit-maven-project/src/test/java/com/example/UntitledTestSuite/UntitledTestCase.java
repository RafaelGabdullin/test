package com.example.UntitledTestSuite;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.example.UntitledTestSuite.Entities.AccountData;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class UntitledTestCase extends TestBase {


  @Test
  public void testUntitledTestCase() throws Exception {
//    Развернем окно на полный экран
    driver.manage().window().maximize();
//    Открытые главного экрана
    openHomePage();
//    Авторизация
    login(data);
//  добавление сущности
    addProductToCart();
//    изменение сущности
    changeQuantity();
//    удаление сущности
    deleteAllProduct();
  }

  private void deleteAllProduct() {
    driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/button")).click();
  }

  private void changeQuantity() {
    driver.get("https://kazanexpress.ru/cart");
    driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[5]/div/div/div/button")).click();
    driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[5]/div/div/div/button")).click();
    driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[5]/div/div/button"));
  }

  private void addProductToCart() {
    WebElement productTel = driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div/div[2]/div/div[1]/a[1]/div/div[2]"));
    productTel.click();
    driver.get("https://kazanexpress.ru/product/Smartfon-POCO-C40-332-1944040");
    driver.findElement(By.xpath("//div[@id='product-info']/div[2]/div[2]/div/div[2]/div/div/div/div[2]")).click();
    driver.findElement(By.xpath("/html/body/div/main/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[5]/div/div/div[1]/button")).click();
    driver.findElement(By.id("cart-button")).click();
  }


  private void login(AccountData data) throws InterruptedException{
    driver.findElement(By.xpath("//main[@id='main-page']/div/header/div/div/div[3]/a/i")).click();
    WebElement phoneInput = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/div[1]/div/input"));
    phoneInput.click();
    phoneInput.clear();
    phoneInput.sendKeys(data.username);
    WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/div[2]/div/input"));
    passwordInput.click();
    passwordInput.clear();
    passwordInput.sendKeys(data.password);
    WebElement signIN = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/button"));
    signIN.click();
  }

  private void openHomePage() {
    driver.get("https://kazanexpress.ru/#");
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
