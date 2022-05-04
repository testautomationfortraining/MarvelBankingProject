package com.marvelbank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() {
		
		 prop=new Properties();
		
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\usrin\\eclipse-workspace\\MarvelSeleniumBankProjectAutomation\\src\\main\\java\\com\\marvelbank\\qa\\"
					+ "config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browserName.equals("FF")) {
			System.setProperty("Webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver=new FirefoxDriver();
		} else {
			System.out.println("None of the browsers identified");
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

}
