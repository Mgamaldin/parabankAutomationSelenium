package com.parabank;

import com.parabank.Pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseClass{

    HomePage homePage;
    SoftAssert softAssert;

    @BeforeClass
    public void Intialize(){
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test (dataProvider = "SuccessfulLogin")
    public void SuccessfulLogin(String val , String val2 , String Status){
        homePage.login(val,val2);
        softAssert.assertEquals(homePage.accountHeaderDisplayed(),"Accounts Overview");
        softAssert.assertTrue(homePage.isWelcomeDisplayed());
        softAssert.assertAll();
        System.out.println(Status);
        homePage.logout();
    }

    @Test (dataProvider = "FailedLogin")
    public void failedLogin(String userName , String passWord , String Status){
        homePage.login(userName,passWord);
        softAssert.assertEquals(homePage.errorMsgDisplayed(),"Please enter a username and password.");
        softAssert.assertAll();
        System.out.println(Status);

    }


    @DataProvider(name = "SuccessfulLogin")
    public Object[][] correctDataProvider() {

        return new Object[][] { { "test" , "testpass" , "First Scenario with Valid Username and Password"} ,
                                {"test1" , "test1" , "Second Scenario with Valid Username and Password"}};
    }

    @DataProvider(name = "FailedLogin")
    public Object[][] wrongDataProvider() {
        return new Object[][] { { " " , " " , "Scenario with Empty Username and Password"} ,
                                {"!@#" , "!@#" , "Scenario with Special Characters for Username and Password"} ,
                                {"test" , "FailData" , "Scenario with valid Username and Invalid Password"},
                                {"FailData" , "FailData" , "Scenario with Invalid Username and valid Password"}};
    }


}
