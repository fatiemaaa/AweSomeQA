package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_ResetPassword {
    WebDriver driver;

    public P04_ResetPassword(WebDriver driver){
        this.driver=driver;
    }

    private final By EMAIL_TEXT=By.xpath("(//input)[4]");
    private final By CONTINUE_BUTTON=By.xpath("(//input)[5]");

    public P04_ResetPassword enterEmail(String email){
        driver.findElement(this.EMAIL_TEXT).sendKeys(email);
        return this;
    }
    public P04_ResetPassword clickContinueButton(){
        driver.findElement(this.CONTINUE_BUTTON).click();
        return this;
    }
}
