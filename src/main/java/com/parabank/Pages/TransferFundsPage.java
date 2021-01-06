package com.parabank.Pages;

import com.parabank.ElementsRepo.TransferFundsPageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends NavigationBase {


    public TransferFundsPage (WebDriver driver) {
        super(driver);
    }

    public Boolean isNavigatedSuccessfully(){
        waitUntilElementIsVisible(TransferFundsPageObjects.TITLE_HEADER);
        return driver.findElement(By.xpath(TransferFundsPageObjects.TITLE_HEADER)).isDisplayed();
    }

    public void transferFund(String amount , String value){
        selectFromDropdown(TransferFundsPageObjects.FROMACCOUNT_DROPDOWN,value);
        selectFromDropdown(TransferFundsPageObjects.TOACCOUNT_DROPDOWN,value);
        InsertData(TransferFundsPageObjects.AMOUNT_FIELD,amount);
        clickButton(TransferFundsPageObjects.TRANSFER_BUTTON);
    }

    public String successTransferMassage(){
        waitUntilElementIsVisible(TransferFundsPageObjects.TRANSFER_SUCCESSMSG);
        return driver.findElement(By.xpath(TransferFundsPageObjects.TRANSFER_SUCCESSMSG)).getText();
    }

    public String errorMassage(){
        waitUntilElementIsVisible(TransferFundsPageObjects.ERROR_AMOUNT_MSG);
        return driver.findElement(By.xpath(TransferFundsPageObjects.ERROR_AMOUNT_MSG)).getText();
    }

}
