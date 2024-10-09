package testcases;

import org.testng.annotations.Test;
import pages.P02_RegisterPage;
import  static util.Utility.*;

public class TC02_Register extends TestBase{

    static String firstname= generateRandomFirstName();
    static String lastname= generateRandomLastName();
     static String email= generateRandomGmail();
    static String password= generateRandomPassword(6);
    static String TelefoneNumber= "023456799";




    @Test(priority = 1, description = "Register with valid Data")
    public void RegisterwithvalidData(){
        new P02_RegisterPage(driver).enterfirstname(firstname)
        .enterlastname(lastname).
                EMAIL(email).EnterPassword(password).
                ConfirmPassword(password)
               .Telefone(TelefoneNumber).
               ClickOnTermsAndConditions();
        System.out.println(firstname +" "+ lastname +" "+ email +" "+ password +" "+ TelefoneNumber);
    }



}
