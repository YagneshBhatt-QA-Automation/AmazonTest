package com.Amazon_App.Functionality;

import com.Amazon_App.base.TestBase;
import com.Amazon_App.ObjectRepo.Amazon_CartPage_OR;
import com.Amazon_App.ObjectRepo.Amazon_HomePage_OR;
import com.Amazon_App.ObjectRepo.Amazon_ProductPage_OR;
import com.Amazon_App.ObjectRepo.Amazon_SearchResultPage_OR;
import  com.Amazon_App.Util.PropertyData;
import com.Amazon_App.Util.ReusableFunctions;



import org.apache.log4j.Logger;
import org.junit.Assert;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAfterLogin extends TestBase{

	private static Logger logger = Logger.getLogger(LoginScreen.class.getName());
    PropertyData data = new PropertyData();
    
    public static boolean validate_AmazonLogo_displayed() {
    	boolean flag = true;
    	try {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		logger.info("Verify the presence of the " + Amazon_HomePage_OR.AmazonLogo + "in current Page");
		Assert.assertTrue(Amazon_HomePage_OR.AmazonLogo.isDisplayed());    	
    }catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While Verifying Amazon logo  Screen Elements: "+Ex.getMessage());
    }
		return flag;
	}
    
    
    /**
	 * Searching for the Product Based on the User Input
	 * @param Product
	 */
	
	public static boolean search_for_product(String Product) {
		boolean flag = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Waiting for the Element" + Amazon_ProductPage_OR.AllowPermission);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.HomeSearch));
		logger.info("Verify the presence of the " + Amazon_SearchResultPage_OR.HomeSearch + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPage_OR.HomeSearch.isDisplayed());
		logger.info("Click the Element " + Amazon_SearchResultPage_OR.HomeSearch);
		Amazon_SearchResultPage_OR.HomeSearch.click();
			try {
				logger.info("Click the Element " + Amazon_CartPage_OR.ClearSearch);
				Amazon_CartPage_OR.ClearSearch.click();

			}
			catch(Exception E) {
				 flag = false;
				logger.info("Expected scenarios is not Presnet");
				System.out.println("Searching for the First Time");
			}
	
		logger.info("Enter the text " + Product + " to the text Field");
		Amazon_SearchResultPage_OR.HomeSearch.sendKeys(Product);
		logger.info("Waiting for the Element" + Amazon_SearchResultPage_OR.SearchDropDown);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.SearchDropDown));
		logger.info("Click the Element " + Amazon_SearchResultPage_OR.SearchDropDown);
		Amazon_SearchResultPage_OR.SearchDropDown.click();
		logger.info("Waiting for the Element" + Amazon_SearchResultPage_OR.ResultsCount);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.ResultsCount));	
		
	}catch(Exception Ex){
	    flag = false;
	    logger.error("Exception Occurred While Verifying Amazon logo  Screen Elements: "+Ex.getMessage());
	}
		return flag;
	}

	public static boolean verify_the_suggestion_page() {
		boolean flag = true;
		try {
		logger.info("Swipe the Current Card with the Given Co-Ordinates");
		ReusableFunctions.swipeHorizontal();
		}catch(Exception Ex){
		    flag = false;
		    logger.error("Exception Occurred While verify suggestion screen: "+Ex.getMessage());
		}
		return flag;
	}
	
	public static boolean  validate_options_menu(String Options) {
		boolean flag = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
		if(Options.equals("Search Bar")) {
			logger.info("Waiting for the Element" + Amazon_SearchResultPage_OR.HomeSearch);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.HomeSearch));
		logger.info("Verify the presence of the " + Amazon_SearchResultPage_OR.HomeSearch + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPage_OR.HomeSearch.isDisplayed());
		}
		else if (Options.equals("65-inch TV")) {
			logger.info("Waiting for the Element" + Amazon_SearchResultPage_OR.ResultsCount);	
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_SearchResultPage_OR.ResultsCount));
		logger.info("Verify the presence of the " + Amazon_SearchResultPage_OR.ResultsCount + "in current Page");
		Assert.assertTrue(Amazon_SearchResultPage_OR.ResultsCount.isDisplayed());
		}
		}catch(Exception Ex){
		    flag = false;
		    logger.error("Exception Occurred While validate option manu: "+Ex.getMessage());
		}
		
		return flag;
	}
	
	
public static boolean choose_the_current_location() {
	    boolean flag = true;
		try {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
		logger.info("Click the Element " + Amazon_HomePage_OR.AmazonLogo);
		Amazon_HomePage_OR.AmazonLogo.click();
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.Devliver);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.Devliver));
		logger.info("Click the Element " + Amazon_HomePage_OR.Devliver);
		Amazon_HomePage_OR.Devliver.click();
		logger.info("Waiting for the Element" + Amazon_HomePage_OR.useCurrentLocation);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.useCurrentLocation));
		logger.info("Click the Element " + Amazon_HomePage_OR.useCurrentLocation);
		Amazon_HomePage_OR.useCurrentLocation.click();
		logger.info("Waiting for the Element" + Amazon_ProductPage_OR.AllowPermission);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AllowPermission));
		logger.info("Click the Element " + Amazon_ProductPage_OR.AllowPermission);
		Amazon_ProductPage_OR.AllowPermission.click();
		}catch(Exception Ex){
		    flag = false;
		    logger.error("Exception Occurred While verify suggestion screen: "+Ex.getMessage());
		}
		return flag;
	}

	 public static boolean user_selects_the_list()  {
		boolean flag = true;
		/**
		 * Scrolling to validate the list of Products
		 */
		try {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		logger.info("Scrolling to the Requested Element by Text");
		ReusableFunctions.scrollToText("TCL");		
		logger.info("Waiting for the Element" + Amazon_ProductPage_OR.RandomResult);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.RandomResult));
		logger.info("Verify the presence of the " + Amazon_ProductPage_OR.RandomResult + "in current Page");
		Assert.assertTrue(Amazon_ProductPage_OR.RandomResult.isDisplayed());
		logger.info("Waiting for the Element" + Amazon_ProductPage_OR.Inches);
		wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.Inches));
		logger.info("Verify the presence of the " + Amazon_ProductPage_OR.Inches + "in current Page");
		Assert.assertTrue(Amazon_ProductPage_OR.Inches.isDisplayed());
		}catch(Exception Ex){
		    flag = false;
		    logger.error("Exception Occurred While select the product from list: "+Ex.getMessage());
		}
		return flag;
	}
	 
	 
	 public static boolean verify_product_details() {
		 	boolean flag = true;
		 	try {
		 	WebDriverWait wait = new WebDriverWait(driver, 10);	
			logger.info("Waiting for the Element" + Amazon_ProductPage_OR.ProdcutName);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.ProdcutName));
			logger.info("Get the Details of ChoosenProduct");
			String ProductName = Amazon_ProductPage_OR.ProdcutName.getText();
			System.out.println("The Selected Product is : " + ProductName);
			logger.info("Verify the Choosen Product is same as TV or not");
			Assert.assertTrue("The suggestions are not having expected Product", ProductName.contains("TCL"));
		 	}catch(Exception Ex){
			    flag = false;
			    logger.error("Exception Occurred While select the product from list: "+Ex.getMessage());
			}
			return flag;
		}

	 public static boolean user_verifies_the_details()  {
			boolean flag = true;
			
			try {
				
			logger.info("Get the Name of ChoosenProduct");
			String ProductDetailsPage = Amazon_ProductPage_OR.ProdcutName.getText();
			logger.info("Verify the Choosen Product is same as TV or not");			
			String ProductName = Amazon_ProductPage_OR.ProdcutName.getText();
			Assert.assertEquals(ProductDetailsPage, ProductName);
			System.out.println("The Name of the Choosen Prodcut is :"+ProductDetailsPage);
			logger.info("Get the Price of ChoosenProduct");
			String ProductPrice = Amazon_ProductPage_OR.Price.getText();
			System.out.println("The Price of the Choosen Prodcut is: "+ProductPrice);
			}catch(Exception Ex){
			    flag = false;
			    logger.error("Exception Occurred while verify details: "+Ex.getMessage());
			}
			return flag;
		}
	 
	 
	 public static boolean user_adds_the_product_to_cart()  {
		    boolean flag = true;
		    try {
		    	WebDriverWait wait = new WebDriverWait(driver, 10);	
			logger.info("Add the Procut to Cart by Scrolling to Add Cart Section");
			Thread.sleep(4000);
			ReusableFunctions.scrollToText("Add to Cart");
			logger.info("Waiting for the Element" + Amazon_ProductPage_OR.AddedToCart);
			wait.until(ExpectedConditions.elementToBeClickable(Amazon_ProductPage_OR.AddedToCart));
			logger.info("Verify the presence of the " + Amazon_ProductPage_OR.AddedToCart + "in current Page");
			Assert.assertTrue(Amazon_ProductPage_OR.AddedToCart.isDisplayed());
	        }catch(Exception Ex){
		    flag = false;
		    logger.error("Exception Occurred while add product to cart: "+Ex.getMessage());
		    }
		return flag;
		}
	 
	    public static boolean user_closes_the_app()  {
	    	boolean flag = true;
	    	try {
			logger.warn("Closing the App");
			driver.closeApp();
	    	 }catch(Exception Ex){
	 		    flag = false;
	 		    logger.error("Exception Occurred while add product to cart: "+Ex.getMessage());
	 		    }
	 		return flag;
		}
	 
	 
}
