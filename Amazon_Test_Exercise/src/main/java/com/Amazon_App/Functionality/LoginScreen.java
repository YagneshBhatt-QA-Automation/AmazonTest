package com.Amazon_App.Functionality;


import com.Amazon_App.base.TestBase;



import com.Amazon_App.ObjectRepo.Amazon_HamburgerMenu_OR;
import com.Amazon_App.ObjectRepo.Amazon_HomePage_OR;
import com.Amazon_App.ObjectRepo.Amazon_LoginPage_OR;
import  com.Amazon_App.Util.PropertyData;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.ScreenOrientation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginScreen extends TestBase {

    private static Logger logger = Logger.getLogger(LoginScreen.class.getName());
    PropertyData data = new PropertyData();

    // Android App
    public static boolean login_to_amazon_app(String Username,String Pwd,String Screenname)  {
	    boolean flag = true;
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    
	    try {
	     if (Screenname.contains("Home"))	{
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 	
		    logger.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.HelloSignIn);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenu_OR.HelloSignIn));
	     }
	     else if(Screenname.contains("Main"))
	     {
	    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 	
	 	    logger.info("Waiting for the Element" + Amazon_LoginPage_OR.SignIn);
	 		wait.until(ExpectedConditions.elementToBeClickable(Amazon_LoginPage_OR.SignIn));
	     }
		logger.info("Get the Current Orientation of the Device");
		ScreenOrientation CurrentScreen = driver.getOrientation();
		System.out.println("The Oreintation of Current Page is : "+ CurrentScreen );		
		logger.info("Rotate the Current Orientation to LANDSCAPE" );
		driver.rotate(ScreenOrientation.LANDSCAPE);
		logger.info("Rotate the Current Orientation to PORTRAIT" );
		driver.rotate(ScreenOrientation.PORTRAIT);			
		 if (Screenname.contains("Home"))	{
			    logger.info("Click the Element " + Amazon_HamburgerMenu_OR.HelloSignIn);
				Amazon_HamburgerMenu_OR.HelloSignIn.click();	
		     }
		     else if(Screenname.contains("Main"))
		     {
		    	 logger.info("Click the Element " + Amazon_LoginPage_OR.SignIn);
		    	 Amazon_LoginPage_OR.SignIn.click();			 	    
		     }		
		logger.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.MobileNumberOrEmail);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenu_OR.MobileNumberOrEmail));		
		logger.info("Click the Element " + Amazon_HamburgerMenu_OR.MobileNumberOrEmail);
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.click();
		logger.info("Clear the text Field before entering any value");
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.clear();
		logger.info("Enter the text " + Username + "to the text Field");
		Amazon_HamburgerMenu_OR.MobileNumberOrEmail.sendKeys(Username);
		logger.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.Continue);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HamburgerMenu_OR.Continue));
		logger.info("Click the Element " + Amazon_HamburgerMenu_OR.Continue);
		Amazon_HamburgerMenu_OR.Continue.click();
		logger.info("Waiting for the Element" + Amazon_LoginPage_OR.Password);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_LoginPage_OR.Password));
		logger.info("Click the Element " + Amazon_LoginPage_OR.Password);
		Amazon_LoginPage_OR.Password.click();
		logger.info("Enter the text " + Pwd + "to the text Field");
		Amazon_LoginPage_OR.Password.sendKeys(Pwd);
		logger.info("Waiting for the Element" + Amazon_LoginPage_OR.Login);
		wait.until(ExpectedConditions.visibilityOf(Amazon_LoginPage_OR.Login));
		logger.info("Click the Element " + Amazon_LoginPage_OR.Login);
		Amazon_LoginPage_OR.Login.click();
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.visibilityOf(Amazon_HomePage_OR.AmazonLogo));
	    }catch(Exception Ex){
            flag = false;
            logger.error("Exception Occurred While Verifying Login Screen Elements: "+Ex.getMessage());
        }
		return flag;
	}
}