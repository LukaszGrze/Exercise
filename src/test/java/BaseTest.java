import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    MainPage mainPage;
    CartPage cartPage;
    WomenPage womenPage;
    ClothesPage clothesPage;
    MenPage menPage;

    private WebDriver driver;


    String URL = "https://autodemo.testoneo.com/";
    String expectedWomenPage = "WOMEN";
    String expectedQuantity = "Ilość: 2";
    String expectedTotalPrice = "Razem: 70,65 zł (brutto)";
    String expectedCartText = "W koszyku nie ma jeszcze produktów";
    String expectedBackgroundColor = "#2fb5d2";


    @BeforeTest
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void driverQuit() {
        driver.quit();
    }





}
