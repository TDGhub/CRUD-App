package crudTests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ComputerPage;
import pageObjects.LandingPage;
import resources.base;

public class PositiveTests extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	//public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized for PositiveTests");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	
	@Test(dataProvider = "getData")
	public void webCreateComp_PT(String name, String intro, String discon) throws IOException {
		log.info("Creating a computer..");
		LandingPage lp = new LandingPage(driver);
		lp.getCreateNewBtn().click();
		
		ComputerPage cp = new ComputerPage(driver);
		cp.getName().sendKeys(name);
		cp.getIntroduced().sendKeys(intro);
		cp.getDiscontinued().sendKeys(discon);
		cp.getCompany();
		cp.getCreateBtn_confirm();
		AssertJUnit.assertTrue(lp.getMsg().isDisplayed());
		//AssertJUnit.assertEquals(lp.getTitle().getText(), "614 computers found");
		log.info("Successfully created a computer!");
	}
	

	
	@Test(dataProvider = "getDataUpdate")
	public void webUpdateComp_PT(String name, String intro, String discon) throws IOException {
		log.info("Updating a computer..");
		LandingPage lp = new LandingPage(driver);
		ComputerPage cp = lp.getComputer();
		
		//ComputerPage cp = new ComputerPage(driver);
		cp.getName().clear();
		cp.getName().sendKeys(name);
		cp.getIntroduced().clear();
		cp.getIntroduced().sendKeys(intro);
		cp.getDiscontinued().clear();
		cp.getDiscontinued().sendKeys( discon);
		cp.getCompany();
		cp.getSaveBtn();
		AssertJUnit.assertTrue(lp.getMsg().isDisplayed());
		//AssertJUnit.assertEquals(lp.getTitle().getText(), "614 computers found");
		log.info("Successfully updated a computer!");
		
	}
	@Test
	public void webDeleteComp_PT() throws IOException {
		log.info("Deleting a computer..");
		LandingPage lp = new LandingPage(driver);
		ComputerPage cp = lp.getComputer();
		cp.getDeleteBtn();
		AssertJUnit.assertTrue(lp.getMsg().isDisplayed());
		//AssertJUnit.assertEquals(lp.getTitle().getText(), "613 computers found");
		log.info("Successfully deleted a computer");
	}
	
	@DataProvider
	public Object getData() {
		Object[][] data = new Object[1][3];
		data[0][0] = "TD Computer4";
		data[0][1] = "2021-07-12";
		data[0][2] = "2021-08-15";
		
		return data;
	}
	@DataProvider
	public Object getDataUpdate() {
		Object[][] data = new Object[1][3];
		data[0][0] = "VS Computer4";
		data[0][1] = "2021-08-01";
		data[0][2] = "2022-10-15";
		
		return data;
	}
	
	@AfterTest 
	public void quit() {
		driver.close(); 
	}
}
