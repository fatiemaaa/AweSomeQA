package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.fail;
import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P06_CheckOutPage {

    //1- web driver declaration
    //2- constructor
    // 3- locators
    //4- public action method


    WebDriver driver;
    public P06_CheckOutPage(WebDriver driver){
        this.driver=driver;
    }

    //3- locators
    private final By FirstName = By.xpath("//input[@id='input-payment-firstname']");
    private final By LastName = By.xpath("//input[@id='input-payment-lastname']");
    private final By CompanyName = By.xpath("//input[@id='input-payment-company']");
    private final By AddressName= By.xpath("//input[@id='input-payment-address-1']");
    private final By CityName = By.xpath("//input[@id='input-payment-city']");
    private final By PostCode = By.xpath("//input[@id='input-payment-postcode']");
    private final By CountryDropDown = By.xpath("//select[@id='input-payment-country']");
    private final By RegionDropDown = By.xpath("//select[@id='input-payment-zone']");
    private final By ContinueBillingButton = By.xpath("//input[@id='button-payment-address']");
    private final By ContinueDeliveryDetailsButton = By.xpath("//input[@id='button-shipping-address']");
    private final By ContinueDeliveryMethodBtn = By.xpath("//input[@id='button-shipping-method']");
    private final By AddCommentsText = By.xpath("//textarea[@name='comment']");
    private final By AgreeCheckBox = By.xpath("//input[@type='checkbox']");
    private final By ContinuePaymentMethodBtn = By.xpath("//input[@id='button-payment-method']");
    private final By ConfirmOrderBtn = By.xpath("//input[@value='Confirm Order']");
    private final By GetTextSuccessOrder = By.xpath("//p[text()='Your order has been successfully processed!']");

    //4- public action method
    public P06_CheckOutPage firstName(String fName) throws InterruptedException {
        try {
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(FirstName));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }
        driver.findElement(this.FirstName).sendKeys(fName);
        return this;
    }

        public P06_CheckOutPage lastName (String lName){
            try {
                shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(LastName));
            } catch (TimeoutException exception) {
                fail("Element not found");
            }
            driver.findElement(this.LastName).sendKeys(lName);
            return this;
        }

        public P06_CheckOutPage companyName (String cName){
            try {
                shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(CompanyName));
            } catch (TimeoutException exception) {
                fail("Element not found");
            }
            driver.findElement(this.CompanyName).sendKeys(cName);
            return this;
        }
        public P06_CheckOutPage addressName (String aName){
            try {
                shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(AddressName));
            } catch (TimeoutException exception) {
                fail("Element not found");
            }
            driver.findElement(this.AddressName).sendKeys(aName);
            return this;
        }
        public P06_CheckOutPage cityname (String cName){
            try {
                shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(CityName));
            } catch (TimeoutException exception) {
                fail("Element not found");
            }
            driver.findElement(this.CityName).sendKeys(cName);
            return this;
        }
        public P06_CheckOutPage postCode (String pCode){
            try {
                shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(PostCode));
            } catch (TimeoutException exception) {
                fail("Element not found");
            }
            driver.findElement(this.PostCode).sendKeys(pCode);
            return this;
        }


        public void  countryDDL() throws InterruptedException {


            // Select Randomly form country list
            // Create a Select object for interacting with the dropdown
            WebElement countryElement = driver.findElement(CountryDropDown);
            Select selectCountry = new Select(countryElement);
            // Get all the options in the dropdown
            List<WebElement> optionsCountry = selectCountry.getOptions();
            // Exclude the first option if it is "Please Select" (usually index 0)
            int randomIndexCountry = new Random().nextInt(optionsCountry.size() - 1) + 1; // Starts from 1 to avoid first item
            // Select a random option from the dropdown
            selectCountry.selectByIndex(randomIndexCountry);
            Thread.sleep(500);
            // Select Randomly from Region list
            WebElement regionDropdown = driver.findElement(RegionDropDown);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(regionDropdown));  // Wait until the region dropdown is enabled

// Now, check if the region dropdown is enabled
            if (regionDropdown.isEnabled()) {
                Select selectRegion = new Select(regionDropdown);
                List<WebElement> optionsRegion = selectRegion.getOptions();

                // Exclude the first option if it is "Please Select" (usually index 0)
                if (optionsRegion.size() > 1) {  // Ensure there are options available
                    int randomIndexRegion = new Random().nextInt(optionsRegion.size() - 1) + 1; // Starts from 1 to avoid the first item
                    selectRegion.selectByIndex(randomIndexRegion);
                } else {
                    System.out.println("Region dropdown has no selectable options.");
                }
            } else {
                System.out.println("Region dropdown is disabled.");
            }

            Thread.sleep(500);
            driver.findElement(ContinueBillingButton).click();

        }
        //2- DeliveryDetails

        public void DeliveryDetails () throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueDeliveryDetailsButton));
            continueBtn.click();

        }
        // 3- DeliveryMethod
        public void DeliveryMethod (String Comments){
            // Wait until AddCommentsText is clickable and then send the comments
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement commentsField = wait.until(ExpectedConditions.elementToBeClickable(AddCommentsText));
            commentsField.sendKeys(Comments);

            // Wait until ContinueDeliveryMethodBtn is clickable and then click it
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinueDeliveryMethodBtn));
            continueBtn.click();
        }
        // 4- PaymentMethod
        public void PaymentMethod () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the AgreeCheckBox is clickable and then click it
            WebElement agreeCheckBox = wait.until(ExpectedConditions.elementToBeClickable(AgreeCheckBox));
            agreeCheckBox.click();

            // Wait until ContinuePaymentMethodBtn is clickable and then click it
            WebElement continuePaymentBtn = wait.until(ExpectedConditions.elementToBeClickable(ContinuePaymentMethodBtn));
            continuePaymentBtn.click();
        }
        //5- ConfirmOrder
        public void ConfirmOrder () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until ConfirmOrderBtn is clickable and then click it
            WebElement confirmOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(ConfirmOrderBtn));
            confirmOrderBtn.click();
        }
        //6- GetSuccessOrderMessage
        public String GetSuccessOrderMessage () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until GetTextSuccessOrder is visible and then get the text
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(GetTextSuccessOrder));
            return successMessage.getText();
        }


    }



