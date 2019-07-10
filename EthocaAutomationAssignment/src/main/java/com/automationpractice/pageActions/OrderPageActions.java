package com.automationpractice.pageActions;



import org.openqa.selenium.JavascriptExecutor;

import com.automationpractice.pages.OrderPage;
import com.automationpractice.resources.Base;

public class OrderPageActions extends Base {

	OrderPage myOrderPage = new OrderPage(driver);

	public boolean fillRegistrationInformation(String FName, String LName, String pswd, String Address, String City,
			String State, String Postalcode, String MobileNo) {

		if (myOrderPage.setFirstNamePersonalInfo(FName) && myOrderPage.setLastNamePersonalInfo(LName)
				&& myOrderPage.setPassword(pswd) && myOrderPage.setAddress(Address) && myOrderPage.setCity(City)
				&& myOrderPage.setState(State) && myOrderPage.setPostal(Postalcode)
				&& myOrderPage.setMobilePhoneNumber(MobileNo)) {
			Log.info("**************Succesfully filled the registration form*************");
			return true;
		} else {
			Log.info("**************Failed to fill the registration form*************");
			return false;
		}

	}
	
	
	public boolean verifyProductDescriptionAtPayments(String RowNum, String ProductName, String Size) {
		
		boolean productMatch = myOrderPage.getProductNamePayment(RowNum).equalsIgnoreCase(ProductName);
		boolean sizeMatch= myOrderPage.getProductSizeAndColor(RowNum).contains("Size : "+Size);
		
		if (productMatch&& sizeMatch) {
			Log.info("**************Product and size is correct at Payments tab*************");
			return true;
			
		}else {
			Log.info("**************Either Product or Size does not match at Payments tab*************");
			return false;
		}

		
	}
	
	
	
	
	/***
	 * 
	 * @return
	 */
	public boolean clickproceedToCheckOutButton() {
		scrollUp(300);
		return myOrderPage.clickproceedToCheckOutButton();

	}
	
	/***
	 * 
	 * @param Email
	 * @return
	 */
	public boolean setCreateAccountEmail(String Email) {
		scrollUp(250);
		return  myOrderPage.setCreateAccountEmail(Email);

	}
	
	
	/***
	 * 
	 * @return
	 */
	public boolean clickCreateAccountButton() {
		return myOrderPage.clickCreateAccountButton();

	}
	
	
	/***
	 * 
	 * @return
	 */
	public boolean clickRegisterButton() {
		return myOrderPage.clickRegisterButton();

	}
	

	/***
	 * 
	 * @return
	 */
	public boolean clickAcceptTermsAndConditions() {
		return myOrderPage.clickAcceptTermsAndConditions();

	}

}
