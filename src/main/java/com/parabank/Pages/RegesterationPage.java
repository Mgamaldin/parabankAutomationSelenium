package com.parabank.Pages;

import com.parabank.ElementsRepo.RegesterationPageObjects;
import com.parabank.Utils.Randomizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegesterationPage extends NavigationBase {

    public RegesterationPage (WebDriver driver) {
        super(driver);
    }


    public void regesterUserData(String firstName,String lastName,String address,String city,String state,String userNAme,String password){
        InsertData(RegesterationPageObjects.FIRSTNAME_FIELD,firstName);
        InsertData(RegesterationPageObjects.LASTNAME_FIELD,lastName);
        InsertData(RegesterationPageObjects.ADDRESS_FIELD,address);
        InsertData(RegesterationPageObjects.CITY_FIELD,city);
        InsertData(RegesterationPageObjects.STATE_FIELD,state);
        InsertData(RegesterationPageObjects.ZIPCODE_FIELD, Randomizer.generateRandomizedNumber());
        InsertData(RegesterationPageObjects.PHONE_FIELD,Randomizer.generateRandomizedNumber());
        InsertData(RegesterationPageObjects.SSN_FIELD,Randomizer.generateRandomizedNumber());

        InsertData(RegesterationPageObjects.USERNAME_FIELD,userNAme);
        InsertData(RegesterationPageObjects.PASSWORD_FIELD,password);
        InsertData(RegesterationPageObjects.CONFIRMPASSWORD_FIELD,password);

        clickButton(RegesterationPageObjects.REGISTER_BUTTON);

    }

    public Boolean isNavigatedSuccessfully(){
        waitUntilElementIsVisible(RegesterationPageObjects.TITLE_HEADER);
        return driver.findElement(By.xpath(RegesterationPageObjects.TITLE_HEADER)).isDisplayed();
    }


    public String errorMassage(){
        waitUntilElementIsVisible(RegesterationPageObjects.Error_MSG);
        return driver.findElement(By.xpath(RegesterationPageObjects.Error_MSG)).getText();
    }


}
