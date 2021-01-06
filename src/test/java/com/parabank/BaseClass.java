package com.parabank;

import com.parabank.Utils.SystemPropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;


    @BeforeTest
    public void intialization(){
        WebDriverManager.chromedriver().targetPath("src/main/resources/Driver/version80/").setup();
        //System.setProperty("webdriver.chrome.driver","src/main/resources/Driver/chromedriver/win32/87.0.4280.88/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if(SystemPropertiesReader.getHeadlessState()) options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

        String url = SystemPropertiesReader.getBaseUrl();
        driver.get(url);
        System.out.println("Application url is: " + url);
    }

    @AfterTest
    public void cleanupSpec() {
        driver.close();
        driver.quit();
    }



}
