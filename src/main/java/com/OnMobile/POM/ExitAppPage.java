package com.OnMobile.POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidKeyCode;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.OnMobile.GenericLib.Driver;

public class ExitAppPage extends Driver {
	static Logger logger = Logger.getLogger(ExitAppPage.class);
	
	static By clickonYesButton=MobileBy.AndroidUIAutomator("text(\"Yes\")");
	
	
	public static void exitFromApp(){
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElement(clickonYesButton).click();
		}
	
	public static void home(){
		driver.pressKeyCode(AndroidKeyCode.HOME);
	}

}
