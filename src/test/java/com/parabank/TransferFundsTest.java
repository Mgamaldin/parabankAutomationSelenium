package com.parabank;

import com.parabank.Pages.HomePage;
import com.parabank.Pages.TransferFundsPage;
import com.parabank.Utils.SystemPropertiesReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TransferFundsTest extends BaseClass {

    HomePage homePage;
    TransferFundsPage transferFundsPage;
    SoftAssert softAssert;
    String userName = SystemPropertiesReader.getUsername(),
            passWord =SystemPropertiesReader.getPassword() , amount = "12345" , dropDownValue="13455";

    @BeforeClass
    public void Intialize(){
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        homePage.login(userName, passWord);
    }

    @Test(priority = 1)
    public void transferFunds(){
        transferFundsPage= homePage.goToTransferFundsPage();
        softAssert.assertTrue(transferFundsPage.isNavigatedSuccessfully());
        transferFundsPage.transferFund(amount,dropDownValue);
        softAssert.assertEquals(transferFundsPage.successTransferMassage(),"$"+amount+".00 has been transferred from account #"+dropDownValue+" to account #"+dropDownValue+".","Transfer didnot get approved Successfully");
        softAssert.assertAll();
    }

    @Test (priority = 2)
    public void transferFundsAmountFieldValidation(){
        transferFundsPage= homePage.goToTransferFundsPage();
        softAssert.assertTrue(transferFundsPage.isNavigatedSuccessfully());
        transferFundsPage.transferFund("",dropDownValue);
        softAssert.assertEquals(transferFundsPage.successTransferMassage(),"The amount cannot be empty." );
        softAssert.assertAll();
    }


    @AfterClass
    public void teardown(){
       homePage.logout();
    }
}
