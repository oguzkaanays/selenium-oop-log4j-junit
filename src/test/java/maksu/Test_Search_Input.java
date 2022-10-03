package maksu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import java.awt.Color;
import java.lang.Thread;
import com.operations.BasketOperations;



public class Test_Search_Input extends BaseTest {



    @Test
    @Order(1)
    public void Search() throws Exception {

        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.setExcelFile("./testdata.xlsx", "Sheet1");
        System.out.println(excelUtil.getCellData("Sutun1", 1));

        //Identify the fields
        WebElement fullName = driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input"));

        fullName.sendKeys(excelUtil.getCellData("Sutun1", 1));
        Thread.sleep(5000);
        fullName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        fullName.clear();
        Thread.sleep(5000);

        Thread.sleep(5000);
        fullName.sendKeys(excelUtil.getCellData("Sutun2", 1));
        fullName.sendKeys(Keys.ENTER);

            //Do save operation or submit as your application supports to save data
            Thread.sleep(3000);

        }

        @Test
        @Order(2)
        public void SelectProduct() throws InterruptedException {

        WebElement product = driver.findElement(By.xpath("//*[@id=\"productList\"]/div[3]/div/div/div[2]/a[2]/span"));
        product.click();
        Thread.sleep(3000);

        WebElement productName = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/h1/span"));
        WebElement productPrice = driver.findElement(By.xpath("//*[@id=\"priceNew\"]"));

        System.out.println(productName.getText());
        System.out.println(productPrice.getText());




        }

        @Test
        @Order(3)
        public void AddtoBag() throws InterruptedException {
       /*     WebElement selectSize = driver.findElement(By.xpath("//*[@id=\"sizes\"]/div/span[5]"));
            selectSize.click();
            Thread.sleep(3000);
            WebElement addtoBag = driver.findElement(By.xpath("//*[@id=\"addBasket\"]"));
            addtoBag.click();
            Thread.sleep(7000);

            WebElement GoTOBag = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/a[3]"));
            GoTOBag.click();
            Thread.sleep(3000); */

            BasketOperations baskedOperation = new BasketOperations(driver);
            /* Rastgele Seçilen ürün sepete eklenir.*/
            WebElement selectSize = driver.findElement(By.xpath("//span[contains(.,'42')]"));
            selectSize.click();
            baskedOperation.addBasked();
            /* Sepet görüntülenir */
            baskedOperation.goToBasked();
            /* Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır. */
           // Assert.assertEquals(baskedOperation.getBaskedPrice(),baskedOperation.getProductPrice());
            /* Adet arttırılarak ürün adedinin 2 olduğu doğrulanır. */
            baskedOperation.baskedProductUp();
           // Assert.assertEquals(baskedOperation.baskedProductUpControl(),"2");
            /* Ürün sepetten silinerek sepetin boş olduğu kontrol edilir. */
            baskedOperation.baskedProductRemove();
           // Assert.assertEquals(baskedOperation.productRemoveControl(),"Sepetiniz Boş");


        }

        @Test
        @Order(4)
        public void EqualisPrice() {
     /*   WebElement productDetailPrice = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/div[2]/ul/li[4]/span[2]"));
        System.out.println(productDetailPrice.getText());

        */
        }

        @Test
        @Order(5)
        public void Select2Product() throws InterruptedException {

      /*  WebElement quantity = driver.findElement(By.xpath("//*[@id=\"quantitySelect0-key-0\"]"));
        quantity.click();
        Thread.sleep(3000);

            quantity.sendKeys("2");
            quantity.sendKeys(Keys.ENTER);

            String control = driver.findElement(By.xpath("//*[@id=\"quantitySelect0-key-0\"]")).getAttribute("value");
            System.out.println(control); */



        }

        @Test
        public void DeleteBag()  {

        }



    }



