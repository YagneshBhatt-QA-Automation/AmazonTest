package com.Amazon_App.Functionality;

import com.Amazon_App.base.TestBase;
import com.Amazon_App.ObjectRepo.Amazon_CartPage_OR;
import com.Amazon_App.ObjectRepo.Amazon_HomePage_OR;
import com.Amazon_App.ObjectRepo.Amazon_ProductPage_OR;

import  com.Amazon_App.Util.PropertyData;

import org.apache.log4j.Logger;
import org.junit.Assert;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VerifyCartProduct extends TestBase {
	private static Logger logger = Logger.getLogger(VerifyCartProduct.class.getName());
    PropertyData data = new PropertyData();

    public static boolean VerifyToCartProduct_Check()
    {   boolean flag = true;
    
        try
        {
        	WebDriverWait wait = new WebDriverWait(driver, 10);
        	//Navigate to cart menu
        	logger.info("Waiting for the Element" + Amazon_HomePage_OR.AmazonLogo);
    		wait.until(ExpectedConditions.elementToBeClickable(Amazon_HomePage_OR.AmazonLogo));
    		logger.info("Click the Element " + Amazon_HomePage_OR.AmazonLogo);
    		Amazon_HomePage_OR.AmazonLogo.click();
    		logger.info("Waiting for the Element" + Amazon_CartPage_OR.CartMenu);
    		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.CartMenu));
    		logger.info("Click the Element " + Amazon_CartPage_OR.CartMenu);
    		Amazon_CartPage_OR.CartMenu.click();
    		logger.info("Waiting for the Element" + Amazon_CartPage_OR.ProceedToBuy);
    		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
    		
    		//Verify cart product
    		logger.info("Waiting for the Element" + Amazon_CartPage_OR.SubTotal);
    		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.SubTotal));
    		String ProductCartPage = Amazon_ProductPage_OR.ProdcutName.getText();
    		logger.info("Verify the Expected Element is displayd on Current Page");
    		Assert.assertTrue(Amazon_ProductPage_OR.ProdcutName.isDisplayed());
    		logger.info("Verify the Product is TV or not");
    		Assert.assertTrue("The product is not present in the Cart", ProductCartPage.contains("TCL"));
    		
    		//Process to buy
    		logger.info("Waiting for the Element" + Amazon_CartPage_OR.ProceedToBuy);
    		wait.until(ExpectedConditions.elementToBeClickable(Amazon_CartPage_OR.ProceedToBuy));
    		logger.info("Click the Element " + Amazon_CartPage_OR.ProceedToBuy);
    		Amazon_CartPage_OR.ProceedToBuy.click();
    		
    		//Close the App
    		logger.warn("Closing the App");
    		driver.closeApp();
        	
        } catch (Exception ex)
        {
        	 flag = false;
        	 logger.info("Add to cart process failed"+ ex.getMessage());
        }
    
        return flag;	
    }
    

}
