package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationpractice.resources.Base;

public class ProductQuickViewPage extends Base {
	public WebDriver driver;
	public ProductQuickViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*WebElements*/
	
	@FindBy(css="select[id='group_1']")
	WebElement sizeDropDown;
	
	@FindBy(css="i[class='icon-plus']")
	WebElement increaseQantityByOne;
	
	@FindBy(css="i[class='icon-plus']")
	WebElement decreaseQantityByOne;
	
	@FindBy(css="input[id='quantity_wanted']")
	WebElement QantityWanted;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement addToCartButton;

	@FindBy(xpath="//span[@class='continue btn btn-default button exclusive-medium']//span[1]")
	WebElement layerCartContinueShopping ;
	
	@FindBy(xpath="//div[@id='layer_cart']//span[@title='Proceed to checkout']")
	WebElement layerCartProceedToCheckOut;
	
	@FindBy(css="span[id='layer_cart_product_title']")
	WebElement layerCartProductName;
	
	@FindBy(css="span[id='layer_cart_product_quantity']")
	WebElement layerCartProductQuantity;
	
	@FindBy(css="span[id='layer_cart_product_quantity']")
	WebElement layerCartProductSuccessMessage;
	
	@FindBy(css="span[class='cross']")
	WebElement layerCartCloseButton;
	

	
	
	
	/***
	 * 
	 * @return
	 */
	public String getLayerCartProductName() {
		if (checkIfElementExistAndVisible(layerCartProductName, "layerCartProductName")){
			return layerCartProductName.getText();
		}else {
			Log.info("***********layerCartProductName is not visible*************");
			return "";
		}
		
	}
	
	
	
	/***
	 * 
	 * @return
	 */
	
	public String getlayerCartProductQuantity() {
		if (checkIfElementExistAndVisible(layerCartProductQuantity, "layerCartProductQuantity")){
			return layerCartProductQuantity.getText();
		}else {
			Log.info("**************layerCartProductName is not visible*************");
			return "";
		}
		
	}
	
	
	/***
	 * 
	 * @return
	 */
	
	public boolean clickContinueShoppingButton() {
		
		waitForElementToGetVisible(layerCartContinueShopping);
		layerCartContinueShopping.click();
	
		return true;
		
	}
	
	
	

	
	/***
	 * 
	 * @return
	 */
	public String getQuantityWantedValue() {
		
		if (checkIfElementExistAndVisible(QantityWanted, "QantityWanted")) {
			return QantityWanted.getAttribute("value");
		}else {
			Log.info("***********WebElement QantityWanted is not visible*************");
			return "0";
		}
		
	}
	
	
	/***
	 * 
	 * @return
	 */
	public boolean  clickaddToCartButton() {
		
		if (checkIfElementExistAndVisible(addToCartButton, "addToCartButton")) {
			addToCartButton.click();
			return true;
		}else {
			System.out.println("***********Unable to click WebElement addToCartButton, as it is not visible*************");
			return false;
		}
		
	}
	
	
	/***
	 * 
	 * @return
	 */
	public boolean  clickdecreaseQantityByOne() {
		
		if (checkIfElementExistAndVisible(decreaseQantityByOne, "decreaseQantityByOne")) {
			decreaseQantityByOne.click();
			return true;
		}else {
			Log.info("***********Unable to click WebElement increaseQantityByOne, as it is not visible*************");
			return false;
		}
		
	}
	
	
	/***
	 * 
	 * @return
	 */
	public boolean  clickincreaseQantityByOne() {
		
		if (checkIfElementExistAndVisible(increaseQantityByOne, "increaseQantityByOne")) {
			increaseQantityByOne.click();
			return true;
		}else {
			Log.info("***********Unable to click WebElement increaseQantityByOne, as it is not visible*************");
			return false;
		}
		
	}
	
	
	
	/***
	 * 
	 * @param Size
	 * @return
	 */
	public boolean setSize( String Size) {
		return selectValueFromDropDown(sizeDropDown,"sizeDropDown",Size);
		
	}
	
	

	/***
	 * 
	 * @param Size
	 * @return
	 */
	public String getSize () {
		Select dropdownd = new Select(sizeDropDown);
		return dropdownd.getFirstSelectedOption().getText();
	}
	
	
	
	

}
