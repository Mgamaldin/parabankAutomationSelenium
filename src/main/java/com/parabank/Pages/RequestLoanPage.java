package com.parabank.Pages;

import com.parabank.ElementsRepo.RequestLoanPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage extends NavigationBase {

    public RequestLoanPage (WebDriver driver) {
        super(driver);
    }

    public Boolean isNavigatedSuccessfully(){
        waitUntilElementIsVisible(RequestLoanPageObject.TITLE_HEADER);
        return driver.findElement(By.xpath(RequestLoanPageObject.TITLE_HEADER)).isDisplayed();
    }

    public void applyLoan(String amount , String downPaymnet , String value){
        selectFromDropdownByValue(RequestLoanPageObject.FROMACCOUNT_DROPDOWN,value);
        InsertData(RequestLoanPageObject.AMOUNT_FIELD,amount);
        InsertData(RequestLoanPageObject.DOWNPAYMENT_FIELD,downPaymnet);
        clickButton(RequestLoanPageObject.APPLY_BUTTON);
    }

    public String successTransferMassage(){
        waitUntilElementIsVisible(RequestLoanPageObject.APPROVED_MSG);
        return driver.findElement(By.xpath(RequestLoanPageObject.APPROVED_MSG)).getText();
    }

    public String errorMassage(){
        waitUntilElementIsVisible(RequestLoanPageObject.ERROR_MSG);
        return driver.findElement(By.xpath(RequestLoanPageObject.ERROR_MSG)).getText();
    }

    public String getLoanstatus(){
        waitUntilElementIsVisible(RequestLoanPageObject.LOAN_STATUS_MSG);
        return driver.findElement(By.xpath(RequestLoanPageObject.LOAN_STATUS_MSG)).getText();
    }

    public String getinsuficintFundError(){
        waitUntilElementIsVisible(RequestLoanPageObject.INSUFICIENT_FUND_MSG);
        return driver.findElement(By.xpath(RequestLoanPageObject.INSUFICIENT_FUND_MSG)).getText();
    }


}
