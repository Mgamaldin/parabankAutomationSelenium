package com.parabank.Pages;

import com.parabank.ElementsRepo.HomePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationBase {

    WebDriver driver ;
    WebDriverWait wait;

    public NavigationBase(WebDriver driver) {
        this.driver = driver;
        wait = (new WebDriverWait(driver, 5));
    }

    public WebDriver getDriver(){
        return this.driver;
    }


    /**
     * This is the wait Generic Functions
     **/

    public void waitUntilElementIsClickable(String detailIdentifier){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(detailIdentifier)));
        } catch (Exception e) {
            System.out.println("Element is not Clickable");
        }
    }

    public void waitUntilElementIsVisible(String detailIdentifier){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(detailIdentifier)));
        } catch (Exception e) {
            System.out.println("Element is not Visible");
        }
    }


    public void clickButton(String Idetifier){
        waitUntilElementIsClickable(Idetifier);
        driver.findElement(By.xpath(Idetifier)).click();
    }

    public void InsertData (String Xpath,String text){
        waitUntilElementIsVisible(Xpath);
        driver.findElement(By.xpath(Xpath)).sendKeys(text);
    }

    public void login(String userName, String passWord){
        InsertData(HomePageObjects.LOGIN_USERNAME_FIELD,userName);
        InsertData(HomePageObjects.LOGIN_PASSWORD_FIELD,passWord);
        clickButton(HomePageObjects.LOGIN_BUTTON);
    }

    public void logout(){
        clickButton(HomePageObjects.LOGOUT_BUTTON);
    }

    public void selectFromDropdown(String identifier , String value){
        waitUntilElementIsVisible(identifier);
        clickButton(identifier);
        clickButton(".//option[@value="+value+"]");
    }

    public void selectFromDropdownByValue(String identifier , String value){
        waitUntilElementIsVisible(identifier);
        Select select = new Select(driver.findElement(By.xpath(identifier)));
        select.selectByValue(value);
    }



}
