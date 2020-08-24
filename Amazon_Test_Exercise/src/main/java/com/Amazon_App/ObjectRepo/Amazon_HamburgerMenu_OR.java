package com.Amazon_App.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon_App.base.TestBase;


public class Amazon_HamburgerMenu_OR extends TestBase {

	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/gno_greeting_text_view")
	public static WebElement HelloSignIn;
	
	@FindBy(xpath = "//android.widget.EditText[@index='1']")
	public static WebElement MobileNumberOrEmail;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	public static WebElement Continue;
}
