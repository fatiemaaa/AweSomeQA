package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.P01_HomePage;
import pages.P04_ResetPassword;

import static testcases.TC02_Register.email;

public class TC04_RestPassword extends TestBase{

    @Test(priority = 1,description = "Validate Reset Password with Already Exists email")
    public void validateResetWithResgisteredEmail() throws InterruptedException {
        new P04_ResetPassword(driver).enterEmail(email).clickContinueButton();
        Thread.sleep(8000);

        SoftAssert softAssert = new SoftAssert();
        String actualMessage = new P04_ResetPassword(driver).VerifyResetTextMessage();
        String expectedMessage = "An email with a confirmation link has been sent your email address.";
        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        softAssert.assertTrue(actualMessage.equals(expectedMessage), "Expected message not found");
        softAssert.assertAll();        System.out.println(actualMessage);

//        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
    }






    }




