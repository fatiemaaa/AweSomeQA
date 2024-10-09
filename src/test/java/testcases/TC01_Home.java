package testcases;

import org.testng.annotations.Test;
import pages.P01_HomePage;

public class TC01_Home extends TestBase{

    @Test(priority = 1,description = "Validate Navigate to Register Page Successfully")
    public void ValidateRegisterNavigation() throws InterruptedException {
        new P01_HomePage(driver).openMyAccountList().clickRegisterListButton();

    }

    @Test(priority = 2, description = "Validate Navigate to Login Page Successfully")
    public void ValidateLoginNavigation() throws InterruptedException {
        new P01_HomePage(driver).openMyAccountList().clickLoginListButton();
        Thread.sleep(5000);
    }
}
