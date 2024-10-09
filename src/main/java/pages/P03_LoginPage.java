package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_LoginPage {
    WebDriver driver;
    public P03_LoginPage(WebDriver driver){
        this.driver=driver;
    }
    private final By EMAIL_TEXT=By.xpath("//input[@id='input-email']");
    private final By PASSWORD_TEXT=By.xpath("//input[@id='input-password']");
    private final By LOGIN_BUTTON=By.xpath("//input[@type='submit']");
    private final By RESET_BUTTON=By.xpath("//div[2]/a[@href=\"https://awesomeqa.com/ui/index.php?route=account/forgotten\"]");

    public P03_LoginPage EnterEmail(String email) throws InterruptedException {
        driver.findElement(this.EMAIL_TEXT).sendKeys(email);
        return this;
    }
    public P03_LoginPage enterPassword(String password){
        driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }
    public P03_LoginPage Click_Login_Button(){
        driver.findElement(this.LOGIN_BUTTON).click();
        return this;
    }
    public P03_LoginPage clickResetButton(){
        driver.findElement(this.RESET_BUTTON).click();
        return this;
    }
}
