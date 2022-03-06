import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyCheckout extends BaseTest{

    @Test
    public void verifyCheckoutTest() throws IOException {
        mainPage.navigateToClothesTab();
        womenPage = mainPage.womenClothesTabClick();
        womenPage.selectSize();
        Assert.assertTrue(womenPage.checkFilters());
        womenPage.navigateToHPSweater();
        womenPage.selectQuantity("2");
        womenPage.addToCart();
        Assert.assertEquals(womenPage.checkQuantity(), expectedQuantity);
        Assert.assertEquals(womenPage.checkTotalPrice(), expectedTotalPrice);
        Assert.assertEquals(womenPage.checkAttribute(), expectedBackgroundColor);
        cartPage = womenPage.proceed();
        cartPage.getScreenshot();
    }


}
