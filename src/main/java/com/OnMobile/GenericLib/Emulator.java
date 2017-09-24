package com.OnMobile.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Emulator {
	private static Logger logger = Logger.getLogger(Emulator.class);
	private static Properties prop = new Properties();
	
	public static void runEmulator(){
		try{
		logger.info("=========================Start Emulator =========================");
		prop.load(new FileInputStream(new  File("./resources/conf/test.properties")));
		Runtime.getRuntime().exec(prop.getProperty("Emulator"));
		
		logger.info("=========================Emulator Launch Successfully =========================");	
		}catch(Exception e){
		logger.error("Error While Launch Emulator ...", e);
		e.printStackTrace();
		}
	}
	
public static void stopEmulator(){
	try{
	logger.info("=========================Stop Emulator =========================");
	prop.load(new FileInputStream(new  File("./resources/conf/test.properties")));
	Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
	logger.info("=========================Stop Emulator Successfully =========================");	
		
	}catch(Exception e){
logger.error("Error While Stop Emulator ...", e);
e.printStackTrace();	
	}
}

}
