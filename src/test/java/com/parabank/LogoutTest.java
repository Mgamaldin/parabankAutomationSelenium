package com.parabank;

import com.parabank.Pages.HomePage;
import com.parabank.Utils.SystemPropertiesReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends BaseClass {


        HomePage homePage;
        SoftAssert softAssert;
        String username= SystemPropertiesReader.getUsername(),
                password=SystemPropertiesReader.getPassword();

        @BeforeClass
        public void Intialize(){
            homePage = new HomePage(driver);
            softAssert = new SoftAssert();
        }

        @Test
        public void SuccessfulLogout(){
            homePage.login(username,password);
            homePage.logout();
            softAssert.assertTrue(homePage.isCustomerLoginDisplayed());
        }

    }
