package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;


public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[normalize-space()='Koszyk']")
    private WebElement cartPage;
    @FindBy(xpath = "//span[@class='price']")
    private WebElement priceBoxContent;
    @FindBy(xpath = "//a[normalize-space()='Hummingbird printed t-shirt']")
    private WebElement nameBoxContent;
    @FindBy(xpath = "//input[@name='product-quantity-spin']")
    private WebElement quantityBoxContent;
    @FindBy(css = ".material-icons.float-xs-left")
    private WebElement deleteButton;
    @FindBy(css = ".no-items")
    private WebElement cartContent;
    @FindBy(css = "a[class='label']")
    private WebElement continueShoppingButton;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }


    public String checkName(){
        return nameBoxContent.getText();
    }
    public String checkPrice(){
        return priceBoxContent.getText();
    }
    public String checkQuantity(){
        return quantityBoxContent.getText();
    }

    public void deleteItems(){
        deleteButton.click();
    }

    public String checkIfRemoved() {
        return cartContent.getText();
    }
    public MainPage continueShopping(){
        continueShoppingButton.click();
        return new MainPage(driver);
    }
    public void getScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("d:\\screenshot.png"));
    }

}
