package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void loadconfig() {
		System.out.println("----BeforeSuite Method----");
		System.out.println("Before Load Config");
		//Below line is Extent Report Setup
		//ExtentManager.setExtent();
		//DOMConfigurator.configure("log4j.xml");
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("After Load Config");
		
	}
	
	  
	  public static void LaunchApp() throws InterruptedException {
      //public static void LaunchApp(String browserName) throws InterruptedException {	
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(111);
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			
			System.out.println(222);
			//To run in Chrome
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//To run in Chrome
			System.out.println(333);
					
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
	    
	      else if (browserName.equalsIgnoreCase("Edge")) {
		    WebDriverManager.iedriver().setup();
		    driver=new EdgeDriver();
		}
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);
		
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(3000);
	}
      
      @BeforeTest
      public void beforeTest() {
    	  System.out.println("----BeforeTest Method----");
      }
      
      @BeforeClass
      public void beforeClass() {
    	  System.out.println("----BeforeClass Method----");
      }
      
      @AfterTest
      public void afterTest() {
    	  System.out.println("----AfterTest Method----");
      }
      
      @AfterClass
      public void afterClass() {
    	  System.out.println("----AfterClass Method----");
      }
      
      
      @AfterSuite
  	  public void afterSuite() {
    	System.out.println("----AfterSuite Method----");
  		//ExtentManager.endReport();
  	}
      
     
 }

     



