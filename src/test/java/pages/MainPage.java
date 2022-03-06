package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "category-3")
    private WebElement clothesTab;
    @FindBy(id = "category-5")
    private WebElement womenClothes;
    @FindBy(xpath = ("//*[contains(text(),'" + "Lost Hat" + "')]"))
    private List<WebElement> list;



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void navigateToClothesTab(){
        wait.until(ExpectedConditions.visibilityOf(clothesTab));
            Actions action = new Actions(driver);
            action.moveToElement(clothesTab).build().perform();
        }

    public WomenPage womenClothesTabClick(){
            wait.until(ExpectedConditions.visibilityOf(womenClothes));
            womenClothes.click();
            return new WomenPage(driver);
        }
    public ClothesPage clothesPageClick(){
        wait.until(ExpectedConditions.visibilityOf(clothesTab));
        clothesTab.click();
        return new ClothesPage(driver);
    }

    public boolean checkTitle() {
        return list.size() > 0;
    }


}
