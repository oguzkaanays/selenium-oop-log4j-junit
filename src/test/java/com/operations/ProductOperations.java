package com.operations;
import com.operations.Paths.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductOperations {


    WebDriver driver;

    By product = By.xpath("//span[contains(.,'Mavi Çizgili Zincir Nakışlı Mini Gömlek Elbise')]");
    By byProductPrice = By.xpath("//*[@id=\"priceNew\"]");



    public ProductOperations(WebDriver driver) {
        this.driver = driver;
    }



    public void productSelect(){
        try {

            Thread.sleep(2000);

            driver.findElement(product).click();


            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
