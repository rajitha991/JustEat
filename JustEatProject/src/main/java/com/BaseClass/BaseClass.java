package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
		public static WebDriver driver;
		public static Properties prop ;
		/*
		 * 
		 *  Initializing the Property file.
		 */
		 
		public BaseClass()
		{
				try {
					
					prop= new Properties();					
					FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ConfigFiles\\config.properties");
					prop.load(file);
				} catch (FileNotFoundException e) {
									e.printStackTrace();
				} catch (IOException e) {
								e.printStackTrace();
				}
		}

		/*
		* setup browser elements and launch browser.
		*/
		public static void initialization(){
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rohitcha\\eclipse-workspace\\JustEatProject\\resources\\chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\rohitcha\\eclipse-workspace\\JustEatProject\\resources\\geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}
		
		}
