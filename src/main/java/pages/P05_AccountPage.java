package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_AccountPage {

    //1- web driver declaration
    //2- constructor
    //3- locators
    //4- public action method

    WebDriver driver;

    public P05_AccountPage(WebDriver driver){
        this.driver=driver;
    }


    //3- locators

    private final By SearchText = By.xpath("//input[@placeholder='Search']");
    private final By SearchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
    private final By HomeButton = By.xpath("//li/a[@href='https://awesomeqa.com/ui/index.php?route=common/home']");
    private final By SearchTEXTRESULTS = By.xpath("//h2[text()='Products meeting the search criteria']");


    //4- public action method
    public void EndUserSearch(String SearchData) throws InterruptedException {
        driver.findElement(SearchText).sendKeys(SearchData);
        driver.findElement(SearchButton).click();
        Thread.sleep(300);
    }

    //5- method for success search for product
    public boolean GetSearchText(){
        return driver.findElement(SearchTEXTRESULTS).isDisplayed();
    }

    //6- openHomePage
    public void OpenHomePage() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(HomeButton).click();
    }


}
