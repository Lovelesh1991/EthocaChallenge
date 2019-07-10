package com.automationpractice.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.openqa.selenium.WebElement;

public class Base {
	public static WebDriver driver;
	public static Properties prop;

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	/***
	 * 
	 * Initialize the Driver
	 */
	public WebDriver initializeDriver() {

		try {

			 prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"D:\\EthocaAutomationAssignment\\EthocaAutomationChallenge\\src\\main\\java\\com\\automationpractice\\resources\\data.properties");

			prop.load(fis);
			String browserName = prop.getProperty("Browser");
		
			System.out.println(prop.getProperty("Browser"));
			
			System.out.println(prop.getProperty("Path"));

			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
				driver = new ChromeDriver();
				// execute in chrome driver

				Log.info("***************Browser Succesfully Initiated" + browserName + "***************");

			}

		}

		catch (FileNotFoundException e) {

			Log.error("##############Exception occured while Loading Properties File###########: "
					+ e.getMessage());

		} catch (IOException e) {

			Log.error("##############Exception occured while executing method hoverOnWebElement###########: "
					+ e.getMessage());

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	/***
	 * This method takes WebElement X and Boolean click as input parameter. i. If
	 * click is true then it hovers over element x and does a click. ii. else if
	 * value of click is false then perform hover only. iii. Returns true on success
	 * and false on fail.
	 * 
	 * @param X
	 * @param click
	 */
	public Boolean hoverOnWebElement(WebElement X, String NameOfWeBelement, Boolean click) {
		Actions hover = new Actions(driver);
		
		if (checkIfElementExistAndVisible(X, NameOfWeBelement)) {
			if (click) {
				hover.moveToElement(X).click().build().perform();
				Log.info("***************Hovered and clicked on" + NameOfWeBelement + "***************");
				return true;
			} else {
				hover.moveToElement(X).build().perform();
				Log.info("***************Hovering on" + NameOfWeBelement + "***************");
				return true;
			}
		} else {
			Log.info("**************Unable to hover as Element is not Visible*************");
			return false;
		}

	}

	/***
	 * i. if element is visible true is returned ii. if element is not visible false
	 * is returned iii.It takes WebElement and Name of WebElement as Input and
	 * returns true if element is visible else returns false
	 * 
	 * @param myElement
	 * @param NameOfWeBelement
	 * @return
	 */
	public boolean checkIfElementExistAndVisible(WebElement myElement, String NameOfWeBelement) {
		try {
			if (waitForElementToGetVisible(myElement)) {
				Log.info("*****************" + NameOfWeBelement + " is visible.***************");
				return true;
			} else {
				Log.info("*****************" + NameOfWeBelement + " is not visible.***************");
				return false;
			}
		} catch (Exception e) {
			Log.info("##############Exception occured while executing method checkIfElementExistAndVisible###########: "
					+ e.getMessage());
			return false;

		}

	}

	/***
	 * i.Takes Drop down Webelement,NameofDropDown,Value to be selected from
	 * dropdown ii.Returns true if Desired value is selected from the Dropdown
	 * iii.Returns False if Desired Value Cannot be Selected from Dropdown
	 * 
	 * @param dropdown
	 * @param NameOfDropDown
	 * @param DesiredValue
	 * @return
	 */
	public boolean selectValueFromDropDown(WebElement dropdown, String NameOfDropDown, String DesiredValue) {

		try {
			Select dropdownd = new Select(dropdown);
			dropdownd.selectByVisibleText(DesiredValue);
			if (dropdownd.getFirstSelectedOption().getText().equalsIgnoreCase(DesiredValue)) {

				Log.info("***************Desired Value is Selected in the Dropdown***********************"
						+ NameOfDropDown);

				return true;

			}

			else {
				Log.info("***************Desired Value Cannot be Selected from the DropDown***********************");

				return false;
			}
		} catch (Exception e) {

			Log.error("##############Exception occured while executing method hoverOnWebElement###########: "
					+ e.getMessage());
			return false;

		}

	}
	
	
	/***
	 * i.Takes Drop down Webelement,NameofDropDown,Value to be selected from
	 * dropdown ii.Returns true if Desired value is selected from the Dropdown
	 * iii.Returns False if Desired Value Cannot be Selected from Dropdown
	 * 
	 * @param dropdown
	 * @param NameOfDropDown
	 * @param DesiredValue
	 * @return
	 */

	
	/***
	 * 
	 * @param Xpath
	 * @return
	 */
	public WebElement findElementWithXpath(String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		return driver.findElement(By.xpath(Xpath));
		
	}

	public Boolean waitForElementToGetVisible(WebElement x) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(x));
		return true;
		
	}

	
	
	/***
	 * 
	 * @param n
	 */
	public void waitForNSeconds(int n) {
		try {
			TimeUnit.SECONDS.sleep(n);
		} catch (InterruptedException e) {
			Log.info(e.getMessage());
		}
	}
	
	
	public void scrollUp(int x) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, "+x+");");
		
		//jse.executeScript("window.scrollBy(0, -"+x+")", "");
		
		
		Log.info("*******************Scrolling Down*********************************************");
		
		
	}
	

}
