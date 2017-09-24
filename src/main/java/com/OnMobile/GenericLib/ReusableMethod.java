package com.OnMobile.GenericLib;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethod extends Driver{
	public static Logger logger = Logger.getLogger(ReusableMethod.class);
	
	public static void waitForPageToLoad(By locator ){
		try{
		logger.info("waitForPageToLoad()...");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(TimeoutException e){
		logger.error("==========Error while Page loading=======",e);
		e.printStackTrace();
		}
		
	}
	
	public static void implicitWait(int i){
		try{
		logger.info("wait for full page load...");
		driver.manage().timeouts().implicitlyWait(i*2, TimeUnit.SECONDS);
		}catch(TimeoutException e){
		logger.error("TimeoutException while page load",e);
		}
	}
	
	public static void waitFor(int i){
		try{
	logger.info("wait for few seconeds .........  ");
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
	logger.error("InterruptedException while page load",e);
		e.printStackTrace();
		}
		}catch(TimeoutException e){
	logger.error("TimeoutException while page load",e);
		}
	}
	
	public void main(){
		
	}

}
