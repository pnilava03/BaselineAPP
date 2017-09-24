package com.OnMobile.POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.OnMobile.GenericLib.Driver;
import com.OnMobile.GenericLib.ReusableMethod;




public class AllowAppPage extends Driver{
	static Logger logger = Logger.getLogger(AllowAppPage.class);
	
	By clickonOkButton=MobileBy.AndroidUIAutomator("text(\"OK\")");
	By clickOn1stAllowButton=MobileBy.AndroidUIAutomator("text(\"Allow\")");
	By clickon2ndAllowButton=By.xpath("//android.widget.Button[@index='2']");
	By clickon3rdAllowButton= By.xpath("//android.widget.Button[@text='Allow']");
	By clickOnLetmeExploreButton=MobileBy.AndroidUIAutomator("text(\"Let me explore\")");
	By clickonOkbutton= MobileBy.AndroidUIAutomator("text(\"Ok\")");
	
	
	
	//this is allow me to app method
	public void allow_Me_To_App(){
	try{
	driver.findElement(clickonOkButton).click();
	driver.findElement(clickOn1stAllowButton).click();
	driver.findElement(clickon2ndAllowButton).click();
	driver.findElement(clickon3rdAllowButton).click();
	ReusableMethod.waitForPageToLoad(MobileBy.AndroidUIAutomator("text(\"Let me explore\")"));
	driver.findElement(clickOnLetmeExploreButton).click();
	driver.findElement(clickonOkbutton).click();
	logger.info("=====================App Launch sucessfully=====================");
	ReusableMethod.implicitWait(10);
	
	}catch(Exception e){
	logger.error("Element Not found Exception ...",e);
	}
		}
	
	
}
	

