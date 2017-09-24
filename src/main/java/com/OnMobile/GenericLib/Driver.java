package com.OnMobile.GenericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	public static Logger logger =Logger.getLogger(Driver.class);
	public static Properties prop = new Properties();
	 public static AndroidDriver<AndroidElement> driver;
	 
	
	 	{
		PropertyConfigurator.configure("./resources/conf/log4j.properties");
		}
	
	public static AndroidDriver<AndroidElement> capabilities(){
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		try {
		logger.info("=================Properties file loading======================");
		prop.load(new FileInputStream("./resources/conf/test.properties"));
		logger.info("=================Properties file Loading======================");
		} catch (FileNotFoundException e) {
		logger.error("FileNotFoundException While loading properties file", e);
		e.printStackTrace();
		} catch (IOException e) {
		logger.error("IOException while fetch data from properties file", e);
		e.printStackTrace();
		}
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));
		capabilities.setCapability(MobileCapabilityType.APP, prop.getProperty("VodafoneIndia"));
		try{
		logger.info("Hit Apppium URL ...");
		driver= new AndroidDriver<AndroidElement>(new URL(prop.getProperty("RemoteURL")),capabilities);
		}catch(Exception e){
		logger.error("Error while Hitting Appium URL", e);
		e.printStackTrace();
		}
		return driver;
		
	}

}
