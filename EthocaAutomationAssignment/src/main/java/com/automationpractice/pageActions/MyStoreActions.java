package com.automationpractice.pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationpractice.pages.MyStore;
import com.automationpractice.resources.Base;

public class MyStoreActions extends Base {

	MyStore myStore = new MyStore(driver);

	/***
	 * i.Select Menu Tab on the landing Page ii. Expects Tab Name to be selected and
	 * boolean argument whether to click on that element or not
	 * 
	 * @param TabName
	 * @param hoverAndClick
	 * @return
	 */

	public boolean selectMenuTab(String TabName, Boolean hoverAndClick) {
		
		String TabPath = "//div[@id='block_top_menu']//a[@class='sf-with-ul'][contains(text(),'" + TabName + "')]";
		return hoverOnWebElement(driver.findElement(By.xpath(TabPath)), "Tab:" + TabName, hoverAndClick);
	}

	/***
	 * i.Select SubMenu Tab 
	 * ii. Expects SubMenuTab Tab Name to be selected
	 * @param Submenu
	 * @param item
	 * @return
	 */
	public boolean selectItemFormSubmenu(String itemCategory) {
		String itemCategoryPath= "//li[@class='sfHover']//a[contains(text(),'"+itemCategory+"')]";
		Log.info("*****************************Trying to click  on Item**************");
		hoverOnWebElement(findElementWithXpath(itemCategoryPath), "Item Category:" + itemCategory, false);
		findElementWithXpath(itemCategoryPath).click();
		return true;

	}


	/***
	 * 
	 * @return
	 */
	public boolean checkOut() {
		if (myStore.hoverOnCart() && myStore.clickCheckOutButton()) {
			return true;
		} else {
			return false;
		}

	}

}
