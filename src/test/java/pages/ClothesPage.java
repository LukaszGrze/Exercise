package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClothesPage {

    private WebDriver driver;
    private WebDriverWait wait;


    public ClothesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//a[normalize-space()='Hummingbird printed t-shirt']")
    private WebElement hpTShirt;

    public MenPage navigateToHPTShirt(){
        hpTShirt.click();
        return new MenPage(driver);

    }

}
