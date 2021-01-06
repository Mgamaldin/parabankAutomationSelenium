package com.parabank;

import com.parabank.Pages.HomePage;
import com.parabank.Pages.RequestLoanPage;
import com.parabank.Utils.SystemPropertiesReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RequestLoanTest extends BaseClass{

    HomePage homePage;
    SoftAssert softAssert;
    RequestLoanPage requestLoanPage;
    String userName= SystemPropertiesReader.getUsername(),
            passWord=SystemPropertiesReader.getPassword() ,
            amount = "300" , dropDownValue="13455" , downpaymentValue="30",
             amountInsuficient = "12345000" , downpaymentInsuficient="1235";


    @BeforeClass
    public void Intialize(){
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
        homePage.login(userName,passWord);
    }

    @Test(priority = 1)
    public void requestLoanwithValidFund(){
        requestLoanPage= homePage.goToRequestLoanPage();
        softAssert.assertTrue(requestLoanPage.isNavigatedSuccessfully());
        requestLoanPage.applyLoan(amount,downpaymentValue,dropDownValue);
        softAssert.assertEquals(requestLoanPage.getLoanstatus(),"Approved","Request Loan didnot get approved Successfully");
        softAssert.assertEquals(requestLoanPage.successTransferMassage(),"Congratulations, your loan has been approved.");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void requestLoanwithInsuficientFund(){
        requestLoanPage= homePage.goToRequestLoanPage();
        softAssert.assertTrue(requestLoanPage.isNavigatedSuccessfully());
        requestLoanPage.applyLoan(amountInsuficient,downpaymentInsuficient,dropDownValue);
        softAssert.assertEquals(requestLoanPage.getLoanstatus(),"Denied");
        softAssert.assertEquals(requestLoanPage.getinsuficintFundError() ,"We cannot grant a loan in that amount with your available funds.");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void requestLoanFieldsValidation(){
        requestLoanPage= homePage.goToRequestLoanPage();
        softAssert.assertTrue(requestLoanPage.isNavigatedSuccessfully());
        requestLoanPage.applyLoan("","",dropDownValue);
        softAssert.assertEquals(requestLoanPage.errorMassage(),"An internal error has occurred and has been logged.");

        requestLoanPage= homePage.goToRequestLoanPage();
        softAssert.assertTrue(requestLoanPage.isNavigatedSuccessfully());
        requestLoanPage.applyLoan(amount,"",dropDownValue);
        softAssert.assertEquals(requestLoanPage.errorMassage(),"An internal error has occurred and has been logged.");

        requestLoanPage= homePage.goToRequestLoanPage();
        softAssert.assertTrue(requestLoanPage.isNavigatedSuccessfully());
        requestLoanPage.applyLoan("",downpaymentValue,dropDownValue);
        softAssert.assertEquals(requestLoanPage.errorMassage(),"An internal error has occurred and has been logged.");

        softAssert.assertAll();
    }

    @AfterClass
    public void teardown(){
        homePage.logout();
    }
}
