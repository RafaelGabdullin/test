package com.example.UntitledTestSuite;

import java.time.Duration;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
//    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.manage().window().maximize();
    driver.get("https://kazanexpress.ru/#");
    driver.findElement(By.xpath("//main[@id='main-page']/div/header/div/div/div[3]/a/i")).click();
    WebElement phoneInput = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/div[1]/div/input"));
    phoneInput.click();
    phoneInput.clear();
    phoneInput.sendKeys("+79274288749");
    WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/div[2]/div/input"));
    passwordInput.click();
    passwordInput.clear();
    passwordInput.sendKeys("chulpan2003R");
    WebElement signIN = driver.findElement(By.xpath("/html/body/div/main/div/div[5]/div/div/div/form/button"));
    signIN.click();
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
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
