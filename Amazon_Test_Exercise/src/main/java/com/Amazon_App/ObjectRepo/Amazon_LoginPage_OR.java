package com.Amazon_App.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon_App.base.TestBase;



public class Amazon_LoginPage_OR extends TestBase{

	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	public static WebElement SignIn;	
	
	@FindBy(xpath = "//android.widget.EditText[@text='Amazon password']")
	public static WebElement Password;
	
	@FindBy(xpath = "//android.widget.Button[@text='Login']")
	public static WebElement Login;
}
