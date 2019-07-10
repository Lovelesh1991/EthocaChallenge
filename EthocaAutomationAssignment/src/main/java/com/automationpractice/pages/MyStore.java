package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.resources.Base;

public class MyStore extends Base {

	//Initializing WebDriver instance
	public WebDriver driver;

	public MyStore(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/*  WebElements */

	@FindBy(css="button[name='submit_search']")
	WebElement searchButton;
	

	@FindBy(css="input[id='search_query_top']")
	WebElement searchBox;
	


	@FindBy(css="a[class='login']")
	WebElement signIn;
	

	@FindBy(css="div[id='contact-link']")
	WebElement contactUs;

	@FindBy(css="a[title='View my shopping cart']")
	WebElement Cart;
	
	@FindBy(css="a[id='button_order_cart']")
	WebElement CheckOutButton;

	
	

	public boolean hoverOnCart() {
		return hoverOnWebElement(Cart, "Cart On MyStore", false);

	}
	
	public boolean clickCheckOutButton(){
		if (checkIfElementExistAndVisible(CheckOutButton, "CheckOutButton")) {
			CheckOutButton.click();
			return true;
		}else {
			Log.info("***********Unable to click WebElement CheckOutButton, as it is not visible*************");
			return false;
		}
		
		
	
		
		
	}
	
	
	
	
	
	
	
}
