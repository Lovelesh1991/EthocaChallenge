package com.automationpractice.pageActions;



import com.automationpractice.pages.ProductQuickViewPage;
import com.automationpractice.resources.Base;

public class ProductQuickViewPageActions extends Base{
	

	ProductQuickViewPage myProductyQuickView = new ProductQuickViewPage(driver);

	
	/***
	 * 
	 * @param Qty
	 * @param Size
	 */
	public boolean addProductQuickView(String Qty, String Size) {
		if(setDesiredQuantity(Qty)&& myProductyQuickView.setSize(Size)&&myProductyQuickView.clickaddToCartButton()) {
			Log.info("**************Product added to cart Succcessfully*************");
			return true;
		}else {
			Log.info("########Failed to add product to the cart############");
			return false;
		}
	
	}
	

	/***
	 * 
	 * @param Qty
	 * @return
	 */
	public boolean setDesiredQuantity(String Qty) {
		int DesiredQty= Integer.parseInt(Qty);
		int CurrentQty = Integer.parseInt(myProductyQuickView.getQuantityWantedValue());
		int difference= DesiredQty-CurrentQty;
		if (difference==0) {
			Log.info("**************Current value is equal to desired value.*************");
			return true;
		}else {
			for(int i=1;i<=difference;i++) {
				myProductyQuickView.clickincreaseQantityByOne();
			}
			
			if (myProductyQuickView.getQuantityWantedValue().equalsIgnoreCase(Qty)) {
				Log.info("**************Quantity set to desired value*************");
				return true;
			}else {
				Log.info("**************Unable to set the desired value.*************");
				return false;
			}
			
		}
		
	}
	
	/***
	 * i.Select Quick View Button on the item Selected ii.Expects Product Name as
	 * input iii. Returns True if action performed in success else return false
	 * 
	 * @param ProductName
	 * @return
	 */
	public boolean verifyProductAddedToProductCart(String ProductName, String Qty) {
		if (myProductyQuickView.getLayerCartProductName().equalsIgnoreCase(ProductName)
				&& myProductyQuickView.getlayerCartProductQuantity().equalsIgnoreCase(Qty)) {
			Log.info("**************Correct Product:" + ProductName + " and Quanity:" + Qty
					+ " Added to cart************");
			return true;
		} else {
			Log.info(
					"************** The Product and quantity added to cart does not match dersired values************");
			return false;
		}
	}
	
	

	/***
	 * 
	 * @return
	 */
	
	public boolean clickContinueShoppingButton() {
		return myProductyQuickView.clickContinueShoppingButton();
			
		
	}
	
	
	
}
