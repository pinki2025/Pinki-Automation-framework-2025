package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver); // initialize the instance variable
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			System.err.print("Invalid browser Name.....Please select chrome or edge only!!!");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for : " + browserName);

		if (browserName == Browser.CHROME) {

			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.EDGE) {

			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			logger.error("Invalid browser Name.....Please select chrome or edge only!!!");
			System.err.print("Invalid browser Name.....Please select chrome or edge only!!!");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser for : " + browserName);

		if (browserName == Browser.CHROME) {

			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1000");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.EDGE) {

			if (isHeadless) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--headless=old");
				option.addArguments("disable-gpu");
				driver.set(new EdgeDriver(option));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.FIREFOX) {

			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			logger.error("Invalid browser Name.....Please select chrome or edge only!!!");
			System.err.print("Invalid browser Name.....Please select chrome or edge only!!!");
		}
	}

	public void goToWebsite(String url) {

		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeBrowserwindow() {

		logger.info("Maximizimng the browser window");
		driver.get().manage().window().maximize();// maximize the window
	}

	public void clickOn(By locator) {

		logger.info("Finding the element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		logger.info("Element found and now performing click" + locator);

		element.click();
	}
	
	public void clickOnCheckbox(By locator) {

		logger.info("Finding the element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now performing click" + locator);

		element.click();
	}
	

	public void clickOn(WebElement element) {

		logger.info("Element found and now performing click" + element);
		element.click();
	}

	public void enterText(By locator, String texttoEnter) {
		// WebElement element = driver.get().findElement(locator);

		logger.info("Finding the element with the locator" + locator);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now enter the text" + texttoEnter);

		element.sendKeys(texttoEnter);
	}

	public void enterSpecialKey(By locator, Keys keytoEnter) {
		logger.info("Finding the element with the locator" + locator);

		// WebElement element = driver.get().findElement(locator);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found and now enter the special key" + keytoEnter);

		element.sendKeys(keytoEnter);
	}

	public String getVisibleText(By locator) {

		logger.info("finding element with the locator" + locator);

		WebElement element = driver.get().findElement(locator);

		logger.info("Element found and now returning the visible text" + element.getText());

		return element.getText();
	}

	public String getVisibleText(WebElement element) {

		logger.info("Returning the visible text" + element.getText());
		return element.getText();
	}

	public List<String> getAllVisibleText(By locator) {

		logger.info("Finding all element with the locator" + locator);

		List<WebElement> elementlist = driver.get().findElements(locator);
		logger.info("Element found and now printing the lists of elements ");
		List<String> visibleTextLists = new ArrayList<String>();
		for (WebElement element : elementlist) {

			System.out.println(getVisibleText(element));
			visibleTextLists.add(getVisibleText(element));
		}
		return visibleTextLists;
	}

	public List<WebElement> getAllElements(By locator) {

		logger.info("Finding all element with the locator" + locator);

		List<WebElement> elementlist = driver.get().findElements(locator);
		logger.info("Element found and now printing the lists of elements ");
		return elementlist;
	}

	public void selectFromDropDown(By dropdownlocator, String optionToSelect) {

		logger.info("Finding element with the locator " + dropdownlocator);
		WebElement element = driver.get().findElement(dropdownlocator);
		Select select = new Select(element);

		select.selectByVisibleText(optionToSelect);
	}

	public void clearText(By textboxlocator) {

		logger.info("Finding element with the locator " + textboxlocator);

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textboxlocator));

		// WebElement element = driver.get().findElement(textboxlocator);

		logger.info("Element found and clearing the textbox field:");
		element.clear();

	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenShotdata = screenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = dateFormat.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenShotdata, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;

	}

}
