package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.pages.LandingPage;
import com.pages.SearchResultPage;

public class SearchResturantsTest extends BaseClass {
		
		LandingPage landingPage ;
		SearchResultPage searchPage;
	
		public SearchResturantsTest() {
			super();	
		}
		
		@BeforeMethod
		public void setup()
		{
				initialization();
				landingPage = new LandingPage();
				
		}
		/*
		 * Test to verify the restuarants are displayed when searched using Post Code "AR51 1AA"
		 */
		@Test(priority=1)
		public void searchRestuarantsValid()
		{
				searchPage= landingPage.searchRestaurantByPostCode("AR51 1AA");
				boolean result = searchPage.verifySearchResults();
				Assert.assertTrue(result);
		}
		/*
		 * Test to verify the error message display when invalid Post Code is displayed.
		 */
		@Test(priority=2	)
		public void searchRestuarantsInvalid()
		{
			boolean result = landingPage.verifyPostCode("AR519A");
			Assert.assertTrue(result);
		}
		
		/*
		 * Test to verify the sort functionality after changing the location.
		 */
		@Test(priority=3)
		public void changeLocationAndSortByDistance() throws Exception
		{
				searchPage= landingPage.searchRestaurantByPostCode("AR51 1AA");
				searchPage.clickChangeLoctaionLink();
				landingPage.clearPostCodeTextBox();
				searchPage= landingPage.searchRestaurantByPostCode("AR51 1AB");
				boolean result = searchPage.sortByOption();
				Assert.assertTrue(result);
		}
		

		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

}
