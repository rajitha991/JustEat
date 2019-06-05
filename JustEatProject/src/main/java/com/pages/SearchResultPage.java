package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;

public class SearchResultPage extends BaseClass {
	
		@FindBy(xpath="//main[@id='skipToMain']//div[@data-test-id='searchresults']//div[@data-test-id='openrestaurants']")
		WebElement searchResults;
		
		@FindBy(xpath="//h3[contains(text(),'Eng - iOS - Test Restaurant')]")
		WebElement resturantName;
		
		@FindBy(xpath="//span[contains(text(),'Sorted by')]")
		WebElement sortBy;
		
		@FindBy(xpath="//main[@id=\"skipToMain\"]/div/a[contains(text(),'change')]")
		WebElement changeLocationLink;
		
		public SearchResultPage() {
			PageFactory.initElements(driver, this);
		}
		
		/*
		 * Verify the display of search results.
		 */
		public boolean verifySearchResults()
		{
				return searchResults.isDisplayed();
		}
		
		public void clickRestuarant()
		{
				resturantName.click();
		}
		
		public boolean sortByOption() throws Exception
		{
					Actions action= new Actions(driver);
					action.moveToElement(sortBy).build().perform();
				WebElement option = driver.findElement(By.xpath("//ul[@data-test-id='sort_options']//li/descendant::label[@for='Distance']"));
				option.click();
				Thread.sleep(2000);
				boolean res = driver.findElement(By.xpath("//span[contains(text(),'Sorted by Distance')]")).isDisplayed();
				return res;
		}
		
		public void clickChangeLoctaionLink()
		{
				changeLocationLink.click();
		}

}
