package testcases;

import org.testng.annotations.Test;
import pages.P04_ResetPassword;

import static testcases.TC02_Register.email;

public class TC04_RestPassword extends TestBase{

    @Test(priority = 1,description = "Validate Reset Password with Already Exists email")
    public void validateResetWithResgisteredEmail(){
        new P04_ResetPassword(driver).enterEmail(email).clickContinueButton();
    }
}
