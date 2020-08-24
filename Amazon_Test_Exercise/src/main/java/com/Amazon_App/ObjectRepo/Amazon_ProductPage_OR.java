package com.Amazon_App.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon_App.base.TestBase;



public class Amazon_ProductPage_OR extends TestBase{

	
	@FindBy(xpath ="//android.view.ViewGroup[@index='0']")
	public static WebElement RandomResult;
	
	@FindBy(xpath ="//*[@resource-id='title_feature_div']")
	public static WebElement Name;
	
	@FindBy(id =  "com.amazon.mShop.android.shopping:id/loc_ux_gps_auto_detect")
	public static WebElement UseMyCurrentLocarion;
	
	@FindBy(id =  "com.android.packageinstaller:id/permission_allow_always_button")
	public static WebElement AllowPermission;
	
//	com.android.permissioncontroller:id/permission_allow_foreground_only_button
//	com.android.permissioncontroller:id/permission_allow_always_button
	
	@FindBy(xpath ="//*[@resource-id='atfRedesign_priceblock_priceToPay']")
	public static WebElement Price;

	@FindBy(id ="com.amazon.mShop.android.shopping:id/glow_subnav_label")
	public static WebElement Inches;
	
	@FindBy(xpath ="//*[@resource-id='bylineInfo_feature_div']")
	public static WebElement ProdcutName;
	
	//@resource-id='title_feature_div']
	@FindBy(xpath ="//android.view.View[@text='FREE Delivery']")
	public static WebElement ProdcutDetails;
	
	@FindBy(xpath ="//android.view.View[@text='From the manufacturer']")
	public static WebElement FromTheManufacturer;
	
	@FindBy(xpath ="//*[@resource-id='add-to-cart-button']")
	public static WebElement AddToCart;
	
//	@FindBy(id ="com.amazon.mShop.android.shopping:id/atc-success")
	@FindBy(id ="a-autoid-1-announce")
	public static WebElement AddedToCart;
}
