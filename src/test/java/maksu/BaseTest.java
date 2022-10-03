package maksu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@ExtendWith(TestResultLogger.class)
public class BaseTest {

    WebDriver driver ;

    @BeforeAll
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Thread.sleep(5999);
        driver.get("https://www.beymen.com/");
        Thread.sleep(5999);
        driver.manage().window().maximize();
        Thread.sleep(5999);
    }


    @AfterAll
    public void tearDown(){
        driver.quit();
    }

}