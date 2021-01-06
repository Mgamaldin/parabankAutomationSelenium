package com.parabank.Pages;

import com.parabank.ElementsRepo.HomePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends NavigationBase{

    public HomePage (WebDriver driver) {
        super(driver);
    }

    public RegesterationPage goToRegisteratiobPage(){
        clickButton(HomePageObjects.REGESTERATION_BUTTON);
        return new RegesterationPage(driver);
    }

    public TransferFundsPage goToTransferFundsPage(){
        clickButton(HomePageObjects.TRANSFERFUNDS_BUTTON);
        return new TransferFundsPage(driver);
    }

    public RequestLoanPage goToRequestLoanPage(){
        clickButton(HomePageObjects.REQUESTLOAN_BUTTON);
        return new RequestLoanPage(driver);
    }

    public String accountHeaderDisplayed(){
        return driver.findElement(By.xpath(HomePageObjects.ACCOUNT_HEADER)).getText();
    }

    public String errorMsgDisplayed(){
        return driver.findElement(By.xpath(HomePageObjects.ERROR_MSG)).getText();
    }

    public Boolean isWelcomeDisplayed(){
        return driver.findElement(By.xpath(HomePageObjects.WELCOME_HEADER)).getText().contains("Welcome");
    }

    public Boolean isCustomerLoginDisplayed(){
        return driver.findElement(By.xpath(HomePageObjects.CUSTOMERLOGIN_HEADER)).getText().contains("Welcome");
    }



}
