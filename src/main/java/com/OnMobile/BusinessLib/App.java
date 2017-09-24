package com.OnMobile.BusinessLib;

import java.time.Duration;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;


import com.OnMobile.GenericLib.Driver;
import com.OnMobile.GenericLib.ReusableMethod;
import com.OnMobile.POM.AllowAppPage;
import com.OnMobile.POM.ExitAppPage;

	
public class App extends Driver{
	
	Logger logger =Logger.getLogger(App.class);
	AllowAppPage allow_app_apge= new AllowAppPage();
	
	public void allow_Me_To_App(){
		try{
		logger.info("======================App Launch===================");
		capabilities();
		ReusableMethod.implicitWait(10);
		//calling AllowAppPage method in Businesslib
		allow_app_apge.allow_Me_To_App();
		}catch(Exception e){
		logger.error("======================App launch Failed===================",e);
		}
	
		
	}
	
	public void exit_App(){
	try{
	logger.info("======================Press back button for Exit the App=======================");
	ReusableMethod.implicitWait(20);
	ExitAppPage.exitFromApp();
	logger.info("======================Sucessfully  Exit the App======================");
	}catch(Exception e){
	logger.error("====================== Error While Exit the App ======================", e);	
	e.printStackTrace();
		}
	}
	
	/*public void scrollApp(){
	logger.info("Scrolling app ....");
	TouchAction action = new TouchAction(driver);
	AndroidElement wb= driver.findElement(MobileBy.AndroidUIAutomator("text(\"Chalti Hai Kya Nau Se Barah\")"));
	String text= driver.findElement(By.id("br.com.vodain.ringbacktones:id/grid_item_text_tune")).getText();
	System.out.println("Print value===========>"+text);
	AndroidElement wb1= driver.findElement(MobileBy.AndroidUIAutomator("text(\"Socha Hai\")"));
	int startY = wb.getLocation().getY() + (wb.getSize().getHeight() / 2);
    int startX = wb.getLocation().getX() + (wb.getSize().getWidth() / 2);
    int endX = wb1.getLocation().getX() + (wb1.getSize().getWidth() / 2);
    int endY = wb1.getLocation().getY() + (wb1.getSize().getHeight() / 2);
    action.press(startX, startY).waitAction(Duration.ofSeconds(2000)).moveTo(endX, endY).release().perform();
	logger.error("=======Error While Scrolling App Top to Button========");
	}*/

}
