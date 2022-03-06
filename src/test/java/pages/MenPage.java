package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;
    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[contains(text(),'Przejdź do realizacji zamówienia')]")
    private WebElement proceedButton;

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement priceBoxContent;
    @FindBy(xpath = "//span[normalize-space()='Hummingbird printed t-shirt']")
    private WebElement nameBoxContent;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement quantityBoxContent;



    String setPriceBox;
    String setReferenceBox;
    String setNameBox;


    public MenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void selectQuantity(String quantity) {
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }
    public void addToCart(){
        addToCartButton.click();
    }

    public void setPriceBox() {
            this.setPriceBox = priceBoxContent.getText();
        }
    public String getPriceBox() {
            return setPriceBox;
        }

    public void setQuantityBox() {
            this.setReferenceBox = quantityBoxContent.getText();
        }

    public String getQuantityBox() {
            return setReferenceBox;
        }

    public void setNameBox() {
            this.setNameBox = nameBoxContent.getText();
        }

    public String getNameBox() {
            return setNameBox;
        }

    public CartPage proceed(){
        proceedButton.click();
        return new CartPage(driver);
    }
}
