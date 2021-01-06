package com.parabank;

import com.parabank.Pages.HomePage;
import com.parabank.Pages.RegesterationPage;
import com.parabank.Utils.Randomizer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegesterationTest extends BaseClass{

    RegesterationPage regesterationPage;
    HomePage homePage;
    SoftAssert softAssert;

    @BeforeClass
    public void Intialize(){
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }


   @Test(dataProvider = "SuccessfulRegister" , priority = 1)
    public void regesteringNewUser(String firstName,String lastName,String address,String city,String state,String userNAme,String password){
        regesterationPage = homePage.goToRegisteratiobPage();
        softAssert.assertTrue(regesterationPage.isNavigatedSuccessfully());
        regesterationPage.regesterUserData(firstName,lastName,address,city,state,userNAme,password);
    }

    @Test(dataProvider = "FailRegister" , priority = 2)
    public void regesteringNewInvalidUser(String firstName,String lastName,String address,String city,String state,String userNAme,String password,String errorMassage){
        regesterationPage = homePage.goToRegisteratiobPage();
        softAssert.assertTrue(regesterationPage.isNavigatedSuccessfully());
        regesterationPage.regesterUserData(firstName,lastName,address,city,state,userNAme,password);
        softAssert.assertEquals(regesterationPage.errorMassage(),errorMassage);
    }

    @DataProvider(name = "SuccessfulRegister")
    public Object[][] correctDataProvider() {

        return new Object[][] { { "Aautomated_User"+ Randomizer.generateRandomizedNumber(), "Aautomated_User"+ Randomizer.generateRandomizedNumber() , "Aautomated_Address"+ Randomizer.generateRandomizedNumber(),"Aautomated_City"+ Randomizer.generateRandomizedNumber(),"Aautomated_State"+ Randomizer.generateRandomizedNumber(),"Aautomated_Username"+ Randomizer.generateRandomizedNumber(),"Aautomated_Password"+ Randomizer.generateRandomizedNumber()}};
    }

    @DataProvider(name = "FailRegister")
    public Object[][] InvalidDataProvider() {

            return new Object[][] { { "", "Lastname"+Randomizer.generateRandomizedNumber() , "Address"+ Randomizer.generateRandomizedNumber(),"City"+ Randomizer.generateRandomizedNumber(),"State"+ Randomizer.generateRandomizedNumber(),"Username"+ Randomizer.generateRandomizedNumber(),"Password"+ Randomizer.generateRandomizedNumber(),"First name is required."},
                {"Firstname"+Randomizer.generateRandomizedNumber(), "" , "Address"+ Randomizer.generateRandomizedNumber(),"City"+ Randomizer.generateRandomizedNumber(),"State"+ Randomizer.generateRandomizedNumber(),"Username"+ Randomizer.generateRandomizedNumber(),"Password"+ Randomizer.generateRandomizedNumber(),"Last name is required."},
                {"Firstname"+Randomizer.generateRandomizedNumber(), "Lastname"+Randomizer.generateRandomizedNumber() , "" ,"City"+ Randomizer.generateRandomizedNumber(),"State"+ Randomizer.generateRandomizedNumber(),"Username"+ Randomizer.generateRandomizedNumber(),"Password"+ Randomizer.generateRandomizedNumber(),"Address is required."},
                {"Firstname"+Randomizer.generateRandomizedNumber(), "Lastname"+Randomizer.generateRandomizedNumber() , "Address"+ Randomizer.generateRandomizedNumber(),"","State"+ Randomizer.generateRandomizedNumber(),"Username"+ Randomizer.generateRandomizedNumber(),"Password"+ Randomizer.generateRandomizedNumber(),"City is required."},
                {"Firstname"+Randomizer.generateRandomizedNumber(), "Lastname"+Randomizer.generateRandomizedNumber() , "Address"+ Randomizer.generateRandomizedNumber(),"City"+ Randomizer.generateRandomizedNumber(),"","Username"+ Randomizer.generateRandomizedNumber(),"Password"+ Randomizer.generateRandomizedNumber(),"State is required."},
                {"Firstname"+Randomizer.generateRandomizedNumber(), "Lastname"+Randomizer.generateRandomizedNumber() , "Address"+ Randomizer.generateRandomizedNumber(),"City"+ Randomizer.generateRandomizedNumber(),"State"+ Randomizer.generateRandomizedNumber(),"","Password"+ Randomizer.generateRandomizedNumber(),"Username is required."},
                {"Firstname"+Randomizer.generateRandomizedNumber(), "Lastname"+Randomizer.generateRandomizedNumber() , "Address"+ Randomizer.generateRandomizedNumber(),"City"+ Randomizer.generateRandomizedNumber(),"State"+ Randomizer.generateRandomizedNumber(),"Username"+ Randomizer.generateRandomizedNumber(),"","Password is required."},};


}
}
