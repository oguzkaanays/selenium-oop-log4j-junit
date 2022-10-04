package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.operations.BasketOperations;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

// productName ve productPrice

public class TxtUtil {
    public WebDriver driver;
    public void writeToTxt() {

    Date date = new Date() ;
    SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-yyyy HH-mm") ;



    WebElement element = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Mavi Çizgili Zincir Nakışlı Mini Gömlek Elbise')]")));


        //      Find the value and write it to the text file 'Smoke_004 DD-MM-yyyy HH-mm.txt'
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("Smoke_004 " + dateFormat.format(date) + ".txt"), "utf-8"))) {
            writer.write("Product Name + Product Price : " + driver.findElement(By.xpath("//span[contains(.,'Mavi Çizgili Zincir Nakışlı Mini Gömlek Elbise')]")).getText() +
                    driver.findElement(By.xpath("//ins[@id='priceNew']")).getText()
            );

        } catch (IOException ex) {
            // report
        }
    }






}
