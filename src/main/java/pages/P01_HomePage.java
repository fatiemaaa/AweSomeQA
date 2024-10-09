package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_HomePage {
    // 1- webdriver declaration
    // 2- constructor
    // 3- locators
    // 4- public action methods
    WebDriver driver;
    public P01_HomePage(WebDriver driver){
        this.driver=driver;
    }
    private final By MYACCOUNT_List= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/account\"]");
    private final By REGISTER_LISTBUTTON= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/register\"]");
    private final By LOGIN_LISTBUTTON= By.xpath("//a[@href=\"https://awesomeqa.com/ui/index.php?route=account/login\"]");
    private final By CurrencyList= By.xpath("//div[@class=\"btn-group open\"]");

    public P01_HomePage openMyAccountList(){
        driver.findElement(MYACCOUNT_List).click();
        return this;
    }
    public P01_HomePage clickRegisterListButton() throws InterruptedException {
        driver.findElement(REGISTER_LISTBUTTON).click();
        return this;
    }
    public P01_HomePage clickLoginListButton(){
        driver.findElement(LOGIN_LISTBUTTON).click();
        return this;
    }

    public By getCurrencyList() {
        return CurrencyList;
    }
}
