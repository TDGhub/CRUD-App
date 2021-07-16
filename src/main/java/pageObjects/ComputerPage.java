package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//utilising PageObject design pattern to store webElements for each page so every test case
//using these elements will be updated accordingly if the elements attributes were changed
public class ComputerPage {

	public WebDriver driver;
	LandingPage lp = new LandingPage(driver);
	
	By name = By.id("name");
	By introduced = By.id("introduced");
	By discontinued = By.id("discontinued");
	By company = By.xpath("//select");
	By createBtn_confirm = By.xpath("/html/body/section/form/div/input");
	By saveBtn = By.xpath("/html/body/section/form[1]/div/input");
	By deleteBtn = By.xpath("/html/body/section/form[2]/input");
	By cancelBtn = By.xpath("/html/body/section/form[1]/div/a");
	
	public ComputerPage(WebDriver newdriver) {
		this.driver = newdriver;
	}
	
	public WebElement getName() {
		return driver.findElement(name);
	}
	public WebElement getIntroduced() {
		return driver.findElement(introduced);
	}
	public WebElement getDiscontinued() {
		return driver.findElement(discontinued);
	}
	public Select getCompany() {
		Select select = new Select(driver.findElement(company));
		select.selectByValue("11"); 
		return select;
	}
	public LandingPage getCreateBtn_confirm() {
		driver.findElement(createBtn_confirm).click();
		return lp;
	}
	public LandingPage getSaveBtn() {
		driver.findElement(saveBtn).click();
		return lp;
	}
	public LandingPage getDeleteBtn() {
		driver.findElement(deleteBtn).click();
		return lp;
	}
	public LandingPage getCancelBtn() {
		driver.findElement(cancelBtn).click();
		return lp;
	}
}
