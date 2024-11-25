package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P05_AccountPage;

import static util.Utility.getRandomSearchValue;

public class TC05_Account extends TestBase{

    public static String RandomSearchData = getRandomSearchValue();
    P05_AccountPage Accountpage;

    @Test(priority = 1, description = "Validate Verify Search for Products")
    public void ValidateVerifySearchForProducts() throws InterruptedException {
        Accountpage = new P05_AccountPage(driver);
        Accountpage.EndUserSearch(RandomSearchData);
        Assert.assertTrue(Accountpage.GetSearchText());

    }
}
