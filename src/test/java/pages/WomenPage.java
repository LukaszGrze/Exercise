package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class WomenPage{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//h1[@class='h1'][normalize-space()='Women'])[1]")
    private WebElement womanPage;
    @FindBy(css = "li:nth-child(2) > label > span > input")
    private WebElement sizeM;
    @FindBy(id = "js-active-search-filters")
    private List<WebElement> activeFilters;
    @FindBy(css = ".quick-view")
    private WebElement quickView;
    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;
    @FindBy(css = ".add-to-cart")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='col-md-5 divide-right']//p[2]")
    private WebElement quantity;
    @FindBy(xpath = "//p[contains(text(),'70,65 zł (brutto)')]")
    private WebElement totalPrice;
    @FindBy(xpath = "//a[contains(text(),'Przejdź do realizacji zamówienia')]")
    private WebElement proceedButton;


    public WomenPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public String checkWomenPage() {
        return womanPage.getText();
    }

    public void selectSize(){
        sizeM.click();
    }


    public boolean checkFilters(){
        return activeFilters.size() ==1;
    }

    public void navigateToHPSweater(){
        Actions action = new Actions(driver);
        action.moveToElement(quickView).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(quickView)).click();
    }

    public void selectQuantity(String quantity) {
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }
    public void addToCart(){
        addToCartButton.click();

    }
    public String checkQuantity() {
        wait.until(ExpectedConditions.visibilityOf(quantity));

        return quantity.getText();
    }

    public String checkTotalPrice() {
        wait.until(ExpectedConditions.visibilityOf(totalPrice));
        return totalPrice.getText();
    }

    public CartPage proceed(){
        proceedButton.click();
        return new CartPage(driver);
    }


    public String checkAttribute(){
        String color = proceedButton.getCssValue("background-color");
        String hex = Color.fromString(color).asHex();
        return hex;
    }


}
