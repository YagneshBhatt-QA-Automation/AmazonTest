package com.Amazon_App.testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Amazon_App.Functionality.LoginScreen;
import com.Amazon_App.Functionality.SearchAfterLogin;
import com.Amazon_App.Functionality.VerifyCartProduct;
import com.Amazon_App.Util.ReusableFunctions;
import com.Amazon_App.base.TestBase;
import com.Amazon_App.listeners.ExtentManager;
import com.Amazon_App.testData.DataReader;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class DriverScript extends TestBase {
    
    private static SoftAssert _softAssert;
    private static String testCaseName = null;
    private static ExtentTest extentLogger = null;
    private static ExtentReports extent = null;
    private static Logger logger = null;

    private static HashMap<String, HashMap<String, String>> tcData = DataReader.
            testDataMappedToTestName(prop.getProperty("TestDataExcelFileName"), prop.getProperty("TestDataSheetName"));

    @BeforeMethod
    public static void setUp(Method method) throws IOException {
        driverInitialization();
        driver.resetApp();
        _softAssert = new SoftAssert();
        testCaseName = method.getName();
        extent = ExtentManager.getReporter();
        extentLogger = ExtentManager.getLogger(testCaseName);
        logger = Logger.getLogger(DriverScript.class.getName());
    }

    @Test(priority = 1)
    public void LoginAndSearch(){
        logger.info("Running Step: LoginAndSearch");
        String Uname = tcData.get(testCaseName).get("Username");
        String Pwd = tcData.get(testCaseName).get("Password");
        String Screenname = "Main";
        
        if (!LoginScreen.login_to_amazon_app(Uname,Pwd,Screenname)){
            logger.error("Login unsuccessfull check elements");
            _softAssert.fail("Login unsuccessfull check elements");
        }
        
        if (!SearchAfterLogin.validate_AmazonLogo_displayed()){
            logger.error("Validate amazon logo failed");
            _softAssert.fail("Validate amazon logo failed");
        }
        
        String Button1 =tcData.get(testCaseName).get("ButtonName1");
        if (!com.Amazon_App.Functionality.StartShopping.ClickOnButton(Button1)) {
            _softAssert.fail(Button1 + " with Search Functionality Failed.");
        }
        String Option =tcData.get(testCaseName).get("ButtonName2");
        if(!SearchAfterLogin.validate_options_menu(Option))
        {
        	_softAssert.fail(" with Search Bar validation Failed.");
        }	
        
        if (!SearchAfterLogin.verify_the_suggestion_page()) {
            _softAssert.fail(" with suggession Functionality Failed.");
        }  
        
        if(!SearchAfterLogin.choose_the_current_location())
        {
        	_softAssert.fail(" with Current Location Functionality Failed.");
        }
        
        String Product =tcData.get(testCaseName).get("Product");
        if (!SearchAfterLogin.search_for_product(Product)) {
            _softAssert.fail(Product + " with Search Functionality Failed.");
        }  
        
        Option =tcData.get(testCaseName).get("Product");
        if(!SearchAfterLogin.validate_options_menu(Option))
        {_softAssert.fail(" with 65 inch Validation validation Failed.");}
        
        if(!SearchAfterLogin.user_selects_the_list())
        {	_softAssert.fail(" with user selection Failed."); }
        
        if(!SearchAfterLogin.verify_product_details())
        {_softAssert.fail(" with verify product details Failed."); }	

        if(!SearchAfterLogin.user_verifies_the_details())
        {_softAssert.fail(" with verify user product details Failed."); }
        
        if(!SearchAfterLogin.user_adds_the_product_to_cart())
        {_softAssert.fail(" with add product to cart Failed."); }
        
        if(!SearchAfterLogin.user_closes_the_app())
        {_softAssert.fail(" with close the app Failed."); }	
        
        _softAssert.assertAll();
    }

    @Test(priority = 2)
    public void StartShopping(){
        logger.info("Running Step: StartShopping");
        String Button1 =tcData.get(testCaseName).get("ButtonName1");
        String Button2 =tcData.get(testCaseName).get("ButtonName2");
        
        if (!com.Amazon_App.Functionality.StartShopping.ClickOnButton(Button1)) {
            _softAssert.fail(Button1 + " with Start Shopping Functionality Failed.");
        }
        
        if (!com.Amazon_App.Functionality.StartShopping.VerifyHomePageDisplay()) {
            _softAssert.fail("Home page verification Failed.");
        }
        
        if (!com.Amazon_App.Functionality.StartShopping.ClickOnButton(Button2)) {
            _softAssert.fail(Button2 + " with Start Shopping Functionality Failed.");
        }
        
        String Uname = tcData.get(testCaseName).get("Username");
        String Pwd = tcData.get(testCaseName).get("Password");
        String ScreenName = "Home";
 
        if (!LoginScreen.login_to_amazon_app(Uname,Pwd,ScreenName)){
            logger.error("Element not present on the page.");
            _softAssert.fail("Elements not present on the page");
        }
        
        _softAssert.assertAll();
    }

    @Test(priority = 3)
    public void VerifyCartPrd(){
 
    	String Uname = tcData.get(testCaseName).get("Username");
        String Pwd = tcData.get(testCaseName).get("Password");
        String ScreenName = "Main";
 
        if (!LoginScreen.login_to_amazon_app(Uname,Pwd,ScreenName)){
            logger.error("Element not present on the page.");
            _softAssert.fail("Elements not present on the page");
        }
 
    	
        logger.info("Running Step: StartShopping");
        if(!VerifyCartProduct.VerifyToCartProduct_Check())
        {_softAssert.fail("Elements not present on the page"); }
        
        _softAssert.assertAll();
    }
    
    @AfterMethod
    public void getResult(ITestResult result) throws Exception{

        if(result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = ReusableFunctions.takeScreenShot("DemoApp");
            extentLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            extentLogger.fail(result.getThrowable());
            extentLogger.fail("Snapshot below: " + extentLogger.addScreenCaptureFromPath(screenShotPath, testCaseName));

        }else if(result.getStatus() == ITestResult.SKIP){
            extentLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test case SKIPPED due to below issues:", ExtentColor.GREY));
            extentLogger.skip(result.getThrowable());

        }else if(result.getStatus() == ITestResult.SUCCESS){
            extentLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case PASSED.", ExtentColor.GREEN));
        }

        if (driver != null) {
            driver.resetApp();
        }
    }
    @AfterTest
    public void tearDown(){
        extent.flush();
    }
}

