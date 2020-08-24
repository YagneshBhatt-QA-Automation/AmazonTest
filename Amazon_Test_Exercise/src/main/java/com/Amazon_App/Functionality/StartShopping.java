package com.Amazon_App.Functionality;


import com.Amazon_App.base.TestBase;
import com.Amazon_App.ObjectRepo.Amazon_CartPage_OR;
import com.Amazon_App.ObjectRepo.Amazon_HamburgerMenu_OR;
import com.Amazon_App.ObjectRepo.Amazon_HomePage_OR;
import com.Amazon_App.Util.PropertyData;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class StartShopping extends TestBase {

    private static Logger logger = Logger.getLogger(StartShopping.class.getName());
    PropertyData data = new PropertyData();

    // Android App
 public static boolean ClickOnButton(String Button)  {
	    boolean flag = true;
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    
	    if(Button.equals("Start shopping")) {
			try {
				logger.info("Waiting for the Element" + Amazon_HomePage_OR.SkipSignIn);
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.SkipSignIn));
				logger.info("Click the Element " + Amazon_HomePage_OR.SkipSignIn);
				Amazon_HomePage_OR.SkipSignIn.click();
				logger.info("Waiting for the Element" + Amazon_HomePage_OR.HamburgerMenu);
				wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.HamburgerMenu));
			}
			catch(Exception E) {
				flag = false;
				logger.info("Expected Element is not Presnet");
				System.out.println("Skip Sign in not Displayed Hence moving to HomePage");
			}

		}
		else if (Button.equals("hamburger")) {
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.HamburgerMenu.toString());
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.HamburgerMenu));
		logger.info("Click the Element " + Amazon_HomePage_OR.HamburgerMenu.toString());
		Amazon_HomePage_OR.HamburgerMenu.click();
		logger.info("Waiting for the Element" + Amazon_HamburgerMenu_OR.HelloSignIn.toString());
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HamburgerMenu_OR.HelloSignIn));
		
		}
		else if (Button.equals("Amazon")) {
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		logger.info("Click the Element " + Amazon_HomePage_OR.AmazonLogo);
		Amazon_HomePage_OR.AmazonLogo.click();
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
			
		}
		else if (Button.equals("Proceed to Buy")) {
		logger.info("Waiting for the Element" + Amazon_CartPage_OR.ProceedToBuy);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
		logger.info("Click the Element " + Amazon_CartPage_OR.ProceedToBuy);
		Amazon_CartPage_OR.ProceedToBuy.click();
		try {
			logger.info("Waiting for the Element" + Amazon_CartPage_OR.AddMobileNumber);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.AddMobileNumber));
			System.out.println("Enter your Mobile Number to procced  Order");
		}
		catch(Exception E) {
			flag = false;
			logger.info("Expected Element is not Presnet");
			System.out.println("Enter Address to procced your Order");
		}
			
		}
		return flag;
	}
    
public static boolean VerifyHomePageDisplay() {
		boolean flag = true;	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
			logger.info("Verify the presence of the " + Amazon_HomePage_OR.AmazonLogo + "in current Page");
			Assert.assertTrue(Amazon_HomePage_OR.AmazonLogo.isDisplayed());
		}
		catch(Exception E) {
			flag = false;
			logger.info("Expected Home Screen not Presnet");
			
		}
		return flag;
       }
		

}