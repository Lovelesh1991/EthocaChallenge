package com.automationpractice.TestScripts;

import static org.testng.Assert.assertTrue;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.automationpractice.pageActions.MyStoreActions;
import com.automationpractice.pageActions.OrderPageActions;
import com.automationpractice.pageActions.ProductPageActions;
import com.automationpractice.pageActions.ProductQuickViewPageActions;
import com.automationpractice.pages.OrderPage;
import com.automationpractice.pages.ProductPage;
import com.automationpractice.pages.ProductQuickViewPage;
import com.automationpractice.resources.Base;
import com.automationpractice.resources.readExcelData;
//import com.sun.tools.sjavac.Log;

public class WorkFlow extends Base {

	public MyStoreActions myStoreActions;
	public ProductPageActions productPageActions;
	public ProductQuickViewPageActions quickViewActions;
	public OrderPageActions orderPageActions;
	public ProductPage productPage;
	public OrderPage orderPage;
	public ProductQuickViewPage quickViewPage;

	
	
	// DataProvider fields
	String Tab, ItemCategory, ProductName, Qty, Size, Email, FirstName, LastName, Password,
	Address, City, State, Postalcode, MobileNo, RowNum,ProductSize;

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() {
		driver = initializeDriver();
		Log.info("Driver is Initialized");
		driver.get("http://automationpractice.com");

		Log.info("Navigated to Landing Page");
		driver.manage().window().maximize();

		myStoreActions = new MyStoreActions();
		productPageActions = new ProductPageActions();
		quickViewActions = new ProductQuickViewPageActions();
		orderPageActions = new OrderPageActions();
		
	}

	@Test(dataProvider = "shoppingData")
	public void workFlow(HashMap DataObject) {
		
		 Tab = DataObject.get("ItemCategory").toString();
		 ItemCategory = DataObject.get("ItemCategory").toString();
		 ProductName = DataObject.get("ItemCategory").toString();
		 Qty = DataObject.get("ItemCategory").toString();
		 Size = DataObject.get("ItemCategory").toString();
		 Email = DataObject.get("ItemCategory").toString();
		 FirstName = DataObject.get("ItemCategory").toString();
		 LastName = DataObject.get("ItemCategory").toString();
		 Password = DataObject.get("ItemCategory").toString();
		 Address = DataObject.get("ItemCategory").toString();
		 City = DataObject.get("ItemCategory").toString();
		 State = DataObject.get("ItemCategory").toString();
		 Postalcode = DataObject.get("ItemCategory").toString();
		 MobileNo = DataObject.get("ItemCategory").toString();
		 RowNum = DataObject.get("ItemCategory").toString();
		 ProductSize = DataObject.get("ItemCategory").toString();

		assertTrue(myStoreActions.selectMenuTab(Tab, false), "Step 1");
		assertTrue(myStoreActions.selectItemFormSubmenu(ItemCategory), "Step 2");
		assertTrue(productPageActions.hoverOnProductInGridView(ProductName), "Step 3");
		assertTrue(productPageActions.selectQuickViewOfaProduct(ProductName), "Step 4");
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		assertTrue(quickViewActions.addProductQuickView(Qty, Size), "Step 5");
		assertTrue(quickViewActions.clickContinueShoppingButton(),"Step 6");
		driver.switchTo().defaultContent();
		assertTrue(myStoreActions.checkOut(), "Step 7");
		assertTrue(orderPageActions.clickproceedToCheckOutButton(), "Step 8");
		assertTrue(orderPageActions.setCreateAccountEmail(Email), "Step 9");
		assertTrue(orderPageActions.clickCreateAccountButton(), "Step 10");
		assertTrue(orderPageActions.fillRegistrationInformation(FirstName, LastName, Password, Address, City, State,
				Postalcode, MobileNo), "Step 11");
		assertTrue(orderPageActions.clickRegisterButton(), "Step 12");
		assertTrue(orderPageActions.clickproceedToCheckOutButton(), "Step 13");
		assertTrue(orderPageActions.clickAcceptTermsAndConditions(), "Step 14");
		assertTrue(orderPageActions.clickproceedToCheckOutButton(), "Step 15");
		assertTrue(orderPageActions.verifyProductDescriptionAtPayments(RowNum, ProductName, ProductSize), "Step16");

	}

	
	


	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
	
	
	@DataProvider(name = "shoppingData")
	public Object[][] getDataFromDataprovider(){
		readExcelData dataClass = new readExcelData();
	    return dataClass.getData();
	
	}
	

}




//String Tab = "Women";
//String ItemCategory = "Summer Dresses";
//String ProductName = "Printed Chiffon Dress";
//String Qty = "1";
//String Size = "M";
//String Email = "tset55@cd.com";
//String FirstName = "qwer";
//String LastName = "sdfg";
//String Password = "asdfgh";
//String Address = "gsvchvsbnj";
//String City = "California";
//String State = "California";
//String Postalcode = "12345";
//String MobileNo = "9876543210";
//String RowNum = "1";
//String ProductSize = "M";



///*driver=initializeDriver();
//driver.get("http://automationpractice.com");
//driver.manage().window().maximize();*/
//
//
////st.getWomenTab().click();
////st.getSummerDresses().click();
//
////ProductPage sd=new ProductPage(driver);
//MyStoreActions ma=new MyStoreActions(driver);
//ma.selectMenuTab("Women", false);
// WebDriverWait wait=new WebDriverWait(driver,20);
//// wait.until(ExpectedConditions.visibilityOfAllElements(elements))
//
//
//ma.selectItemFormSubmenu("Summer Dresses");
//Log.info("Navigated to Summer Dress");
//
///*Actions action=new Actions(driver);
//
//try {
//	Thread.sleep(1000);
//} catch (InterruptedException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//
////action.moveToElement(sd.getitem(driver)).build().perform();
//
//WebDriverWait wait= new WebDriverWait(driver,20);
//
////wait.until(ExpectedConditions.elementToBeClickable(sd.clickQuickViewBtn(driver)));
////sd.clickQuickViewBtn(driver).click();*/