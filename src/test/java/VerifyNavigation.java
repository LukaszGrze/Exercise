import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyNavigation extends BaseTest{

    @Test
    public void verifyNavigationTest(){
        mainPage.navigateToClothesTab();
        womenPage = mainPage.womenClothesTabClick();
        Assert.assertEquals(womenPage.checkWomenPage(), expectedWomenPage);
    }


}
