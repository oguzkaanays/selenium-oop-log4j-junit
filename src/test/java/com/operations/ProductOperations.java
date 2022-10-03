package com.operations;
import com.operations.Paths.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductOperations {

    List<WebElement> result;
    WebDriver driver;



    public void productSelect(){
        try {

            WebElement result = (WebElement) driver.findElements(By.xpath("//*[@class='listView ']//*[@class='column']/div/div/a/img"));
            result.click();

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
