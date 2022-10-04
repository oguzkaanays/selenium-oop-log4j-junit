package test;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.lang.Thread;
import com.operations.BasketOperations;
import com.operations.ProductOperations;
import test.TxtUtil;




public class Test_Search_Input extends BaseTest {



    @Test
    @Order(1)
    public void Search() throws Exception {



        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.setExcelFile("./testdata.xlsx", "Sheet1");
        System.out.println(excelUtil.getCellData("Sutun1", 1));

        WebElement search = driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/div/div/input"));

        search.sendKeys(excelUtil.getCellData("Sutun1", 1));
            Thread.sleep(5000);
        search.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        search.clear();
            Thread.sleep(5000);

            Thread.sleep(5000);
        search.sendKeys(excelUtil.getCellData("Sutun2", 1));
        search.sendKeys(Keys.ENTER);

            Thread.sleep(3000);

        }

        @Test
        @Order(2)
        public void SelectProduct() throws InterruptedException {


        ProductOperations productOperations = new ProductOperations(driver);

        productOperations.productSelect();

       // TxtUtil txtUtil = new TxtUtil();

       // txtUtil.writeToTxt();


        }

        @Test
        @Order(3)
        public void basketOperations() throws InterruptedException {

            BasketOperations baskedOperation = new BasketOperations(driver);

            WebElement selectSize = driver.findElement(By.xpath("//span[contains(.,'42')]"));
                selectSize.click();
            baskedOperation.addBasked();
            /* Sepet görüntülenir */
            baskedOperation.goToBasked();
            /* Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır. */
            Assert.assertEquals(baskedOperation.getBaskedPrice(),baskedOperation.getProductPrice());
            /* Adet arttırılarak ürün adedinin 2 olduğu doğrulanır. */
            baskedOperation.baskedProductUp();
            Assert.assertEquals(baskedOperation.baskedProductUpControl(),"1");
            /* Ürün sepetten silinerek sepetin boş olduğu kontrol edilir. */
            baskedOperation.baskedProductRemove();
                Thread.sleep(5000);
            Assert.assertEquals(baskedOperation.productRemoveControl(),"SEPETINIZDE ÜRÜN BULUNMAMAKTADIR");
                Thread.sleep(5000);

        }





    }



