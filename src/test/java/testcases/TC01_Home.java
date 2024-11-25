package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;


public class TC01_Home extends TestBase{


    static String seachbox = "labtop";
    P03_LoginPage loginObject;
    P01_HomePage homePageObject;
    String LoginURL = "https://awesomeqa.com/ui/index.php?route=account/login";
    String RegisterURL = "https://awesomeqa.com/ui/index.php?route=account/register";

    @Test(priority = 1,description = "Validate Navigate to Register Page Successfully")
    public void ValidateRegisterNavigation() throws InterruptedException {
        new P01_HomePage(driver).openMyAccountList().clickRegisterListButton();

    }

    @Test(priority = 2, description = "Validate Navigate to Login Page Successfully")
    public void ValidateLoginNavigation() throws InterruptedException {
        new P01_HomePage(driver).openMyAccountList().clickLoginListButton();
        Thread.sleep(5000);
    }
    @Test(priority = 3, description = "Validate Navigate to Search Button Successfully")
    public void ValidateSearchBtnNavigation() throws InterruptedException {
        new P01_HomePage(driver).SEARCHBOX("labtop").ClickOnSearchBtn();

    }

    @Test(priority = 4, description = "Switch Currency To USD And Verify")
    public void VerifySwitchCurrencyToUSD(){
        new P01_HomePage(driver).Change_Currency_To_USD();

    }
    @Test(priority = 5, description = "Select a category selector, hover and open sub-category if found")
    public void CategorySelector() throws InterruptedException {
        new P01_HomePage(driver).SelectCategory("desktops");
    }
    @Test(priority = 5)
    public void VerifyAddingItemToCart() throws InterruptedException {
        new P01_HomePage(driver).clickLoginListButton();

    }



    @Test(priority = 6)
    public void VerifyOpenCheckOutPage(){
        homePageObject= new P01_HomePage(driver);
        homePageObject.OpenCheckOutPage();
    }



}


