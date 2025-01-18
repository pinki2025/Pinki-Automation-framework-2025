package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.constants.Browser;


public abstract class BrowserUtility {
	
	Logger logger =	LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable
	}

	public BrowserUtility(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver .set(new ChromeDriver());
			
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			
		} else {
			System.err.print("Invalid browser Name.....Please select chrome or edge only!!!");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for : "+browserName);

		if (browserName==Browser.CHROME) {
			
			driver .set(new ChromeDriver());
			
		} else if (browserName == Browser.EDGE) {
			
			driver . set(new EdgeDriver());
			
		}else if (browserName == Browser.FIREFOX) {
			driver . set (new FirefoxDriver());
	
		} else {
			logger.error("Invalid browser Name.....Please select chrome or edge only!!!");
			System.err.print("Invalid browser Name.....Please select chrome or edge only!!!");
		}
	}
	
	public BrowserUtility(Browser browserName,boolean isHeadless) {
		logger.info("Launching browser for : "+browserName);

		if (browserName==Browser.CHROME) {
			
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=old");
			options.addArguments("--window-size=1920,1000");
			driver .set(new ChromeDriver(options));
			}
			else {
				driver .set(new ChromeDriver());
			}
			
		} else if (browserName == Browser.EDGE) {
			
			if(isHeadless) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--headless=old");
				option.addArguments("disable-gpu");
				driver . set(new EdgeDriver(option));
				
			}else {
				driver . set(new EdgeDriver());
			}
			
			
		}else if (browserName == Browser.FIREFOX) {
			
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
			    driver . set (new FirefoxDriver(options));
	
		} else {
			 driver . set (new FirefoxDriver());
		}
			logger.error("Invalid browser Name.....Please select chrome or edge only!!!");
			System.err.print("Invalid browser Name.....Please select chrome or edge only!!!");
		}
	}

	public void goToWebsite(String url) {
		
		logger.info("Visiting the website "+url);
		driver.get().get(url);
	}

	public void maximizeBrowserwindow() {

		logger.info("Maximizimng the browser window");
		driver.get().manage().window().maximize();// maximize the window
	}

	public void clickOn(By locator) {
		
		logger.info("Finding the element with the locator" +locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing click" +locator);
		
		element.click();
	}

	public void enterText(By locator, String texttoEnter)
	{
		WebElement element = driver.get().findElement(locator);
		logger.info("Finding the element with the locator" +locator);
		logger.info("Element found and now enter the text" +texttoEnter);
		
		element.sendKeys(texttoEnter);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		
		logger.info("Element found and now returningbthe visible text"+element.getText());
		return element.getText();
	}
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenshot  = (TakesScreenshot)driver.get();
		File screenShotdata = screenshot.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormat.format(date);
		String path = System.getProperty("user.dir")+ "//screenshots//"+name+" - "+timeStamp +".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotdata, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
		
	}

}
