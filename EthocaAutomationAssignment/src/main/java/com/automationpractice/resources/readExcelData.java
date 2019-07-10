package com.automationpractice.resources;


import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.DataProvider;


public class readExcelData extends Base {

	public  Object [][] getData(){
		
	
		 int numberOfrow= getDatasheetRows();
		Object [][] data =new Object [numberOfrow][0];

		 for(int i=1; i<=(numberOfrow-1);i++ ) {
			 data[i][0]= rowData(i);
		 }
		return data;
		
	}
	
	
	public int getDatasheetRows() {
		//Get the number of Rows
		return 0;
	}
	
	
	public HashMap rowData(int rowNum) {
		//Read Each row and save data into HashMap with ColumnName a Key
		
		
		HashMap <String, String> RData= new HashMap<String, String>();
		return RData;
	}
	
	
	

}
