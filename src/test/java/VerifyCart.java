import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyCart extends BaseTest{


    @Test
    public void verifyCartTest(){
    clothesPage = mainPage.clothesPageClick();
    menPage = clothesPage.navigateToHPTShirt();
    menPage.selectQuantity("3");
    menPage.addToCart();
    menPage.setNameBox();
    menPage.setPriceBox();
    menPage.setQuantityBox();
    cartPage = menPage.proceed();
    Assert.assertEquals(cartPage.checkName(), menPage.getNameBox());
    Assert.assertEquals(cartPage.checkPrice(), menPage.getPriceBox());
    Assert.assertEquals(cartPage.checkQuantity(), menPage.getQuantityBox());
    cartPage.deleteItems();
    Assert.assertEquals(cartPage.checkIfRemoved(), expectedCartText);
    mainPage = cartPage.continueShopping();
    Assert.assertTrue(mainPage.checkTitle(), "Text not found!");

    }

}
