package com.OnMobile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.OnMobile.BusinessLib.App;
import com.OnMobile.GenericLib.AppiumServer;
import com.OnMobile.GenericLib.Emulator;
import com.OnMobile.GenericLib.ReusableMethod;

/**
 * @author nilava.pal
 */
public class AppTest{
	static Logger logger = Logger.getLogger(AppTest.class);
	Properties prop= new Properties();
	App app = new App();
	
		{
		PropertyConfigurator.configure("./resources/conf/log4j.properties");
		
		}
	
	@BeforeSuite
	public void runAppium(){
	Emulator.runEmulator();
	ReusableMethod.waitFor(5);
	//start Appium server
	int port = 4723;
	if(!AppiumServer.checkIfServerIsRunnning(port)) {
	logger.info(port + " Port is not use .. create Appium server session ....");
	AppiumServer.startAppiumServer();
	} else {
	logger.error("Appium Server already running on Port - ::"+port);
		}
}

	@BeforeClass
	public void allowMeToAppPermison(){
	//calling App method in Test  class
	app.allow_Me_To_App();
	}
	
	@Test
	public void launchApp(){
	System.out.println("scrolling App");
	//app.scrollApp();
	}
	
	@AfterClass
	public void exit_From_App(){
	//Exit from App	
	app.exit_App();
	}
	
	
	@AfterSuite
	public void stopAppium(){
	//stop appium server	
	AppiumServer.stopAppiumServer();
	}
	
}
