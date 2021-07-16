package edgeTests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;

import pageObjects.LandingPage;
import resources.base;

public class FilterComputer extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	//public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized for FilteringTest");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	

	@Test(dataProvider = "getData")
	public void webFilterName(String str) throws IOException {
		log.info("Searching for a computer..");
		LandingPage lp = new LandingPage(driver);
		if(str.equals("checkError")) {
			AssertJUnit.assertTrue(lp.getSearchError().isDisplayed());
		}else {
			lp.getSearchBox().clear();
			lp.getSearchBox().sendKeys(str);
			lp.getSearchSubmit().click();
		}
		log.info("Successfully searched for a computer!");
	}
	
	@DataProvider
	public Object getData() {
		Object[][] data = new Object[5][1];
		data[0][0] = "TD1";
		data[1][0] = "td1";
		data[2][0] = "td";
		data[3][0] = "HElloC@mp";
		data[4][0] = "checkError";
		return data;
	}
	@AfterTest 
	public void quit() {
		driver.close(); 
	}
	 
}
