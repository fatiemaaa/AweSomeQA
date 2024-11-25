package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P06_CheckOutPage;

import static util.Utility.*;


public class TC06_CheckOut extends TestBase{
    P06_CheckOutPage checkOutPage;
    String SuccessOrderMessage = "Your order has been successfully processed!";
    String companyName = "Vodafone";
    String cityName = "Berline";
    String postCode = getPostCode();
    String deliveryMethod = generateRandomText();

    @Test(priority = 1, description = "Validate Verify Creating Order Successfully")
    public void ValidateVerifyCreatingOrderSuccessfully() throws InterruptedException {

        checkOutPage= new P06_CheckOutPage(driver);
        checkOutPage.firstName("firstname").lastName("lastname").companyName(companyName).cityname(cityName).postCode(postCode).
                countryDDL();
        checkOutPage.DeliveryDetails();
        checkOutPage.DeliveryMethod(deliveryMethod);
        checkOutPage.PaymentMethod();
        checkOutPage.ConfirmOrder();
        System.out.println(checkOutPage.GetSuccessOrderMessage());
        Assert.assertEquals(checkOutPage.GetSuccessOrderMessage(),SuccessOrderMessage);
    }
}
