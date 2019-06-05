package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.BaseClass.BaseClass;

public class LandingPage extends BaseClass {
	
			@FindBy(name="postcode")
			WebElement postCodeTxtBox;
			
			@FindBy(xpath="//button[@type='submit' and @data-test-id='find-restaurants-button']")
			WebElement searchBtn;
			
			@FindBy(id="errorMessage")
			WebElement invalidPostErrMsg;
			
			public LandingPage() {
				PageFactory.initElements(driver, this);
			}
			
			/*
			 *  Enter post code and search restaurants.
			 */
			public SearchResultPage searchRestaurantByPostCode(String postCode)
			{
						postCodeTxtBox.sendKeys(postCode);
						searchBtn.click();
					return new SearchResultPage();
						
			}
			
			public boolean verifyPostCode(String postCode) 
			{
				postCodeTxtBox.sendKeys(postCode);
				searchBtn.click();
				return(invalidPostErrMsg.isDisplayed());
					
			}
			
			public void clearPostCodeTextBox()
			{
				postCodeTxtBox.clear();
			}
			

		
	
}
