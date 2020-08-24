package com.Amazon_App.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Amazon_App.base.TestBase;



public class Amazon_SearchResultPage_OR extends TestBase{

	
	@FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	public static WebElement HomeSearch;
	
	@FindBy(id ="com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")
	public static WebElement SearchDropDown;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Results')]")
	public static WebElement ResultsCount;
}
