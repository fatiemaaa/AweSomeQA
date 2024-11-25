package testcases;

import org.testng.annotations.Test;
import pages.P03_LoginPage;

import static testcases.TC02_Register.email;
import static testcases.TC02_Register.password;

public class TC03_Login extends TestBase{

    @Test(priority = 1,description = "Login With Valid Data")
    public void loginWithValidData() throws InterruptedException {
        System.out.println("Login email: "+email);
        System.out.println("Login password: "+password);
        new P03_LoginPage(driver).EnterEmail(email).enterPassword(password).Click_Login_Button();
        Thread.sleep(5000);
        // assertion
    }
    @Test(priority = 2,description = "Validate Reset Button Navigate to Reset Page")
    public void validateResetButtonNavigateToResetPage(){
        new P03_LoginPage(driver).clickResetButton();
    }
}
