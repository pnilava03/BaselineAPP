package com.OnMobile.GenericLib;

import java.io.IOException;
import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumServer {
	private static Logger logger = Logger.getLogger(AppiumServer.class);
	private static AppiumDriverLocalService appiumService;
	private static AppiumServiceBuilder builder;
	private static DesiredCapabilities cap;
	private static boolean isServerRunning;
	
	public static void startAppiumServer(){
		try{
		logger.info("====================Start Appium Server=====================");	
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
		appiumService=AppiumDriverLocalService.buildService(builder);
		appiumService.start();
		logger.info("====================Sucessfully Start Appium Server=====================");
		}catch(Exception e){
		logger.error("======Error while start Appium Server======", e);
		e.printStackTrace();
		}
	}
	
	public static void stopAppiumServer(){
	try{
	logger.info("=========================Stop Appium  Server======================");
	appiumService.stop();
	logger.info("=========================Sucessfully Stop Appium  Server======================");
	}catch(Exception e){
	logger.error("======Error while stop Appium Server======", e);
	e.printStackTrace();
		}
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		try{
		logger.info("Checking Appium Server Port is already running ...");
		isServerRunning = false;
		ServerSocket serverSocket;
		try {
		serverSocket = new ServerSocket(port);
		serverSocket.close();
		} catch (IOException e) {
		//If control comes here, then it means that the port is in use
		isServerRunning = true;
		} finally {
		serverSocket = null;
		}
	
		
}catch(Exception e){
logger.error("Appium Server port is already running ... " +e,e);
	}
return isServerRunning;		
		}	

		
}
 
	


