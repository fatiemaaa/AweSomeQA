package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_RegisterPage {

    WebDriver driver;
    public P02_RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    private final By First_Name=By.id("input-firstname");
    private final By Last_Name=By.id("input-lastname");
    private final By Email=By.id("input-email");
    private final By Telefone=By.id("input-telephone");
    private final By Password=By.id("input-password");
    private final By Confirm_Password=By.id("input-confirm");
    private final By Click_On_TermsandConditions= By.xpath("//input[@name='agree']");
    private final By Continue_Button= By.xpath("//input[@type=\"submit\"]");

    public P02_RegisterPage enterfirstname(String firstname){
        driver.findElement(this.First_Name).sendKeys(firstname);
        return this;
    }
    public P02_RegisterPage enterlastname(String lastname){
        driver.findElement(this.Last_Name).sendKeys(lastname);
        return this;
    }
    public P02_RegisterPage EMAIL (String email){
        driver.findElement(this.Email).sendKeys(email);
        return this;
    }
    public P02_RegisterPage Telefone (String Telefone){
        driver.findElement(this.Telefone).sendKeys(Telefone);
        return this;
    }
    public P02_RegisterPage EnterPassword (String password){
        driver.findElement(this.Password).sendKeys(password);
        return this;
    }
    public P02_RegisterPage ConfirmPassword (String ConfrimPassword){
        driver.findElement(this.Confirm_Password).sendKeys(ConfrimPassword);
        return this;
    }
    public P02_RegisterPage ClickOnTermsAndConditions(){
        driver.findElement(this.Click_On_TermsandConditions).click();
        return this;
    }
    public P02_RegisterPage ClickOnContinueButton(){
        driver.findElement(this.Continue_Button).click();
        return this;
    }


}
