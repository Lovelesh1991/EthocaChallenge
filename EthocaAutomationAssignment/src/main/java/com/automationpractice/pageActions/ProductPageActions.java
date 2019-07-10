package com.automationpractice.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.pages.ProductPage;
import com.automationpractice.resources.Base;

public class ProductPageActions extends Base {


	ProductPage myProductPage = new ProductPage(driver);

	/***
	 * i.Hover on the Item in grid ii. Expects Product Name for which action needs
	 * to be performed iii. Returns True if action is successful else return false
	 * 
	 * @param ProductName
	 * @return
	 */
	public boolean hoverOnProductInGridView(String ProductName) {
		String productPath = "//div[@class='product-image-container']/a[@title='" + ProductName + "']";
		
		return hoverOnWebElement(findElementWithXpath(productPath), "ProductName:" + ProductName, false);

	}

	/***
	 * i.Select Quick View Button on the item Selected ii.Expects Product Name as
	 * input iii. Returns True if action performed in success else return false
	 * 
	 * @param ProductName
	 * @return
	 */
	public boolean selectQuickViewOfaProduct(String ProductName) {
		hoverOnProductInGridView(ProductName);
		String quickViewPath = "//div[@class='product-image-container']/a[@title='" + ProductName
				+ "']/following-sibling::a[@class='quick-view']";

		WebElement quickviewButton = findElementWithXpath(quickViewPath);
		if (checkIfElementExistAndVisible(quickviewButton, "Quick View button for" + ProductName)) {
			quickviewButton.click();
			Log.info("**************Successfully Clicked on Quick View button for: " + ProductName + "************");
			return true;
		} else {
			Log.info("**************Failed to  Click on Quick View button for: " + ProductName + "************");
			return false;
		}

	}



}
