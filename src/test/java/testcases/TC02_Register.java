package testcases;

import org.testng.annotations.Test;
import pages.P02_RegisterPage;
import  static util.Utility.*;

public class TC02_Register extends TestBase{

    public static String[] registeredUserData = generateRandomRegisterData(); // Store generated user data globally
    String SuccessRegisterMessage ="Congratulations! Your new account has been successfully created!";

    String firstname= "leo";
    String lastname= "martin";
    static String email= generateRandomGmail();
    static String password= "12345678";
    String TelefoneNumber= "023456799";





    @Test(priority = 1, description = "Register with valid Data")
    public void RegisterwithvalidData(){
        System.out.println("Register email: "+email);
        System.out.println("Register password: "+password);
        new P02_RegisterPage(driver).enterfirstname(firstname)
        .enterlastname(lastname).
                EMAIL(email).EnterPassword(password).
                ConfirmPassword(password)
               .Telefone(TelefoneNumber).
               ClickOnTermsAndConditions()
                .ClickOnContinueButton();
        System.out.println(firstname +" "+ lastname +" "+ email +" "+ password +" "+ TelefoneNumber);
    }



}
