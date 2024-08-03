package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;

public class FirstTest extends BaseClass{
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws InterruptedException {
		//LaunchApp(); 
		System.out.println("iuweyrt734975793746");
		LaunchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void firsetTestCase() {
		
		driver.get("https://test.salesforce.com/");
		
		String url = driver.getCurrentUrl();
		
		Assert.assertEquals(url, "https://test.salesforce.com/");
		
	}

}
