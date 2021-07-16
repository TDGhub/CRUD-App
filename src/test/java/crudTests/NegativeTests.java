package crudTests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ComputerPage;
import pageObjects.LandingPage;
import resources.base;

public class NegativeTests extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	//public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized for NegativeTests");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	
	@Test(dataProvider = "getData")
	public void webCreateComp_NT(String name, String intro, String discon, String msg) throws IOException {
		log.info("Creating a computer..");
		LandingPage lp = new LandingPage(driver);
		lp.getCreateNewBtn().click();
		
		ComputerPage cp = new ComputerPage(driver);
		cp.getName().sendKeys(name);
		cp.getIntroduced().sendKeys(intro);
		cp.getDiscontinued().sendKeys(discon);
		cp.getCompany();
		if(msg.equals("confirm")) {
			cp.getCreateBtn_confirm();
			lp.getError();
			cp.getCancelBtn();
		}else {
			cp.getCancelBtn();
		}
		log.info("Computer successfully NOT created!");
		
	}
	
	
	@Test(dataProvider = "getData")
	public void webUpdateComp_NT(String name, String intro, String discon, String msg) throws IOException {
		log.info("Updating a computer..");
		LandingPage lp = new LandingPage(driver);
		ComputerPage cp = lp.getComputer();
		
		//ComputerPage cp = new ComputerPage(driver);
		cp.getName().clear();
		cp.getName().sendKeys(name);
		cp.getIntroduced().clear();
		cp.getIntroduced().sendKeys(intro);
		cp.getDiscontinued().clear();
		cp.getDiscontinued().sendKeys(discon);
		cp.getCompany();
		if(msg.equals("confirm")) {
			cp.getSaveBtn();
			lp.getError();
			cp.getCancelBtn();
		}else {
			cp.getCancelBtn();
		}
		log.info("Computer successfully NOT updated!");
		
	}
	@Test
	public void webDeleteComp_NT() throws IOException {
		log.info("Deleting a computer..");
		LandingPage lp = new LandingPage(driver);
		ComputerPage cp = lp.getComputer();
		cp.getCancelBtn();
		log.info("Computer successfully NOT deleted!");
	}
	
	@DataProvider
	public Object getData() {
		Object[][] data = new Object[4][4];
		data[0][0] = "TD1";
		data[0][1] = "sdvd";
		data[0][2] = "sdvsd";
		data[0][3] = "confirm";
		
		data[1][0] = "";
		data[1][1] = "2021-07-12";
		data[1][2] = "2021-07-22";
		data[1][3] = "confirm";
		
		data[2][0] = "TD1";
		data[2][1] = "2021-18-12";
		data[2][2] = "2024-07-00";
		data[2][3] = "confirm";
		
		data[3][0] = "TD1";
		data[3][1] = "2021-07-12";
		data[3][2] = "2021-07-22";
		data[3][3] = "cancel";
		
		return data;
	}
	
	@AfterTest 
	public void quit() {
		driver.close(); 
	}
}
