package com.example.UntitledTestSuite;

import com.example.UntitledTestSuite.Entities.AccountData;
import com.example.UntitledTestSuite.Entities.ProductData;
import org.junit.*;


public class UntitledTestCase extends TestBase {

  protected AccountData data = new AccountData("+89274288749", "chulpan2003R");
  protected ProductData product = new ProductData("https://kazanexpress.ru/product/Smartfon-POCO-C40-332-1944040", 5);
  @Test
  public void testUntitledTestCase() throws Exception {
//    Развернем окно на полный экран
    driver.manage().window().maximize();
//    Открытые главного экрана
    openHomePage();
//    Авторизация
    login(data);

  }
  @Test
  public void testUntitledTestCaseTwo() throws Exception{
//    Развернем окно на полный экран
    driver.manage().window().maximize();
//    Открытые главного экрана
    openHomePage();
//    Авторизация
    login(data);
//  добавление сущности
    addProductToCart(product);
//    изменение сущности
    changeQuantity(product.quantity);
//    удаление сущности
    deleteAllProduct();
  }
}
