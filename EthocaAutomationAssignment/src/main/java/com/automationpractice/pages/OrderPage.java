package com.automationpractice.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.resources.Base;

public class OrderPage extends Base {
	// Initializing WebDriver instance
	public WebDriver driver;

	public OrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* WebElements Summary */

	/* WebElements Register */

	@FindBy(css = "input[id='email_create']")
	WebElement emailIDCreateAccount;

	@FindBy(css = "button[id='SubmitCreate']")
	WebElement CreateAccountButton;

	/* WebElements Sign up From */

	// Personal Information
	@FindBy(css = "input[id='customer_firstname']")
	WebElement FirstName_PersonalInfo;

	@FindBy(css = "input[id='customer_lastname']")
	WebElement LastName_PersonalInfo;

	@FindBy(css = "input[id='email']")
	WebElement email_PersonalInfo;

	@FindBy(css = "input[id='passwd']")
	WebElement Password;

	// Address

	@FindBy(css = "input[id='firstnamee']")
	WebElement FirstName_Address;

	@FindBy(css = "input[id='lastname']")
	WebElement LastName_Address;

	@FindBy(css = "input[id='address1']")
	WebElement AddressLine1;

	@FindBy(css = "input[id='city']")
	WebElement City;

	@FindBy(css = "div[id='uniform-id_state']")
	WebElement State;

	@FindBy(css = "input[id='postcode']")
	WebElement PostalCode;

	@FindBy(css = "select[id='id_country']")
	WebElement Country;

	@FindBy(css = "input[id='phone_mobile']")
	WebElement mobilePhoneNumber;

	@FindBy(css = "input[id='alias']")
	WebElement aliasAddress;

	@FindBy(xpath = "//button[@id='submitAccount']/span[contains(text(),'Register')]")
	WebElement registerButton;
	
	/* WebElements Shipping*/
	@FindBy(css = "input[id='cgv']")
	WebElement AcceptTermsAndConditionsCheckBox;
	
	/*WebElements Payments */
	
	@FindBy(xpath = "//tr//td//p[@class='product-name']")
	WebElement ProductNamePaymentsTab;
	
	@FindBy(xpath = "//tr//td//p[@class='product-name']/small[2]")
	WebElement ProductColorAndSizePaymentsTab;
	
	
	/* WebElements bottom */

	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutButton;

	/***
	 * 
	 * @return
	 */
	public boolean clickproceedToCheckOutButton() {
		
		System.out.println("Checking on click to proceed");
		if (checkIfElementExistAndVisible(proceedToCheckOutButton, "proceedToCheckOutButton")) {
			
			
			proceedToCheckOutButton.click();
			return true;
		} else {
			System.out.println(
					"***********Unable to click WebElement proceedToCheckOutButton, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param Email
	 * @return
	 */
	public boolean setCreateAccountEmail(String Email) {
		if (checkIfElementExistAndVisible(emailIDCreateAccount, "emailIDCreateAccount")) {
			emailIDCreateAccount.sendKeys(Email);
			return true;
		} else {
			System.out.println("***********Unable to set WebElement emailIDCreateAccount, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param FristName
	 * @return
	 */
	public boolean setFirstNamePersonalInfo(String FristName) {
		if (checkIfElementExistAndVisible(FirstName_PersonalInfo, "FirstName_PersonalInfo")) {
			FirstName_PersonalInfo.sendKeys(FristName);
			return true;
		} else {
			Log.info("***********Unable to set WebElement FirstName_PersonalInfo, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param LastName
	 * @return
	 */
	public boolean setLastNamePersonalInfo(String LastName) {
		if (checkIfElementExistAndVisible(LastName_PersonalInfo, "LastName_PersonalInfo")) {
			LastName_PersonalInfo.sendKeys(LastName);
			return true;
		} else {
			Log.info("***********Unable to set WebElement LastName_PersonalInfo, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param InputPassword
	 * @return
	 */
	public boolean setPassword(String InputPassword) {
		if (checkIfElementExistAndVisible(Password, "Password")) {
			Password.sendKeys(InputPassword);
			return true;
		} else {
			System.out.println("***********Unable to set WebElement Password, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param FristNameAddress
	 * @return
	 */
	public boolean setFirstNameAddress(String FristNameAddress) {
		if (checkIfElementExistAndVisible(FirstName_Address, "FirstName_Address")) {
			FirstName_Address.sendKeys(FristNameAddress);
			return true;
		} else {
			Log.info("***********Unable to set WebElement FirstName_Address, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param LastNameAddress
	 * @return
	 */
	public boolean setLastNameAddress(String LastNameAddress) {
		if (checkIfElementExistAndVisible(LastName_Address, "LastName_Address")) {
			LastName_Address.sendKeys(LastNameAddress);
			return true;
		} else {
			Log.info("***********Unable to set WebElement LastName_Address, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @param InputAddress
	 * @return
	 */
	public boolean setAddress(String InputAddress) {
		if (checkIfElementExistAndVisible(AddressLine1, "LastName_Address")) {
			AddressLine1.sendKeys(InputAddress);
			return true;
		} else {
			Log.info("***********Unable to set WebElement AddressLine1, as it is not visible*************");
			return false;
		}

	}
	

	/***
	 * 
	 * @param inputCity
	 * @return
	 */
	public boolean setCity(String InputCity) {
		if (checkIfElementExistAndVisible(City, "City")) {
			City.sendKeys(InputCity);
			return true;
		} else {
			Log.info("***********Unable to set WebElement InputCity, as it is not visible*************");
			return false;
		}

	}

	

	
	/***
	 * 
	 * @param inputState
	 * @return
	 */
	
	public boolean setState( String DesiredValue) {
		State.click();
		driver.findElement(By.xpath("//select[@id='id_state']/option[contains(text(),'"+DesiredValue+"')]")).click();
		return true;

	}
	
	/***
	 * 
	 * @param inputPostal
	 * @return
	 */
	public boolean setPostal(String inputPostal) {
		if (checkIfElementExistAndVisible(PostalCode, "PostalCode")) {
			PostalCode.sendKeys(inputPostal);
			return true;
		} else {
			Log.info("***********Unable to set WebElement PostalCode, as it is not visible*************");
			return false;
		}

	}


	

	
	

	
	/***
	 * 
	 * @param inputPhoneNumber
	 * @return
	 */
	public boolean setMobilePhoneNumber(String inputPhoneNumber) {
		if (checkIfElementExistAndVisible(mobilePhoneNumber, "mobilePhoneNumber")) {
			mobilePhoneNumber.sendKeys(inputPhoneNumber);
			return true;
		} else {
			Log.info("***********Unable to set WebElement mobilePhoneNumber, as it is not visible*************");
			return false;
		}

	}

	
	
	/***
	 * 
	 * @param inputAliasAddress
	 * @return
	 */
	public boolean setAliasAddress(String InputAliasAddress) {
		if (checkIfElementExistAndVisible(aliasAddress, "aliasAddress")) {
			aliasAddress.sendKeys(InputAliasAddress);
			return true;
		} else {
			Log.info("***********Unable to set WebElement aliasAddress, as it is not visible*************");
			return false;
		}

	}
	
	

	/***
	 * 
	 * @return
	 */
	public boolean clickCreateAccountButton() {
		if (checkIfElementExistAndVisible(CreateAccountButton, "CreateAccountButton")) {
			CreateAccountButton.click();
			return true;
		} else {
			Log.info("***********Unable to click WebElement CreateAccountButton, as it is not visible*************");
			return false;
		}

	}

	/***
	 * 
	 * @return
	 */
	
	public String getProductNamePayment(String row) {
		 return driver.findElement(By.xpath("//tr["+row+"]//td//p[@class='product-name']")).getText();
		
	}
	
	/***
	 * 
	 * @return
	 */
	
	public String getProductSizeAndColor(String row) {
		 return driver.findElement(By.xpath("//tr["+row+"]//td//p[@class='product-name']/small[2]")).getText();
		
	}
	
	
	
	
	/***
	 * 
	 * @return
	 */
	public boolean clickRegisterButton() {
		if (checkIfElementExistAndVisible(registerButton, "registerButton")) {
			registerButton.click();
			return true;
		} else {
			Log.info("***********Unable to click WebElement registerButton, as it is not visible*************");
			return false;
		}

	}
	
	
	/***
	 * 
	 * @return
	 */
	public boolean clickAcceptTermsAndConditions() {
		if (checkIfElementExistAndVisible(AcceptTermsAndConditionsCheckBox, "AcceptTermsAndConditionsCheckBox")) {
			AcceptTermsAndConditionsCheckBox.click();
			return true;
		} else {
			Log.info("***********Unable to click WebElement AcceptTermsAndConditionsCheckBox, as it is not visible*************");
			return false;
		}

	}


}
