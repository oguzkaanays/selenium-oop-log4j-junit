package com.operations;

import test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class BasketOperations extends BaseTest {


    public WebDriver driver;

    By searchBox = By.xpath("/html/body/header/div/div/div[2]/div/div/div/input");

    By product = By.xpath("//span[contains(.,'Mavi Çizgili Zincir Nakışlı Mini Gömlek Elbise')]");

    By productName = By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/h1/span");

    By byProductPrice = By.xpath("//*[@id=\"priceNew\"]");

    By selectSize = By.xpath("//*[@id=\"sizes\"]/div/span[5]");


    By addtoBasket = By.id("addBasket");
    By GoToBasket = By.xpath("/html/body/header/div/div/div[3]/div/a[3]/span");
    By byBaskedProductPrice = By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/ul/li[4]/span[2]");
    By quantity = By.xpath("//*[@id=\"quantitySelect0-key-0\"]");

     static final By DROPDOWN = By.id("quantitySelect0-key-0");
    By quantityControl = DROPDOWN.cssSelector("#quantitySelect0-key-0 > option:nth-child(2)");

    By byRemoveProduct = By.xpath("//*[@id=\"removeCartItemBtn0-key-0\"]");

    private static String baskedPrice;
    private static String productPrice;

    public String getBaskedPrice() {
        return baskedPrice;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public BasketOperations(WebDriver driver) {
        this.driver = driver;
    }


    public void BaskedOperation(WebDriver driver){
        this.driver = driver;
    }




    public void addBasked(){
        productPrice = driver.findElement(byProductPrice).getText();
        driver.findElement(addtoBasket).click();
    }

    public void goToBasked(){
        try {
            Thread.sleep(10000);
            driver.findElement(GoToBasket).click();
            baskedPrice = driver.findElement(byBaskedProductPrice).getText();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void baskedProductUp(){

        try {
            driver.findElement(quantity).click();
            Thread.sleep(1000);
            driver.findElement(quantity).sendKeys("2");
            Thread.sleep(1000);
            driver.findElement(quantity).sendKeys(Keys.ENTER);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String baskedProductUpControl() throws InterruptedException {
        Thread.sleep(1000);

        String control = driver.findElement(By.id("quantitySelect0-key-0")).getAttribute("value");

        return control;
    }

    public void baskedProductRemove(){
        try {
            driver.findElement(byRemoveProduct).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String productRemoveControl(){
        String control = driver.findElement(By.xpath("//strong[contains(text(),'Sepetinizde Ürün Bulunmamaktadır')]")).getText();
        return control;
    }






}
