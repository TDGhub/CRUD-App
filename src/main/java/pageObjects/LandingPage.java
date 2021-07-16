package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//utilising PageObject design pattern to store webElements for each page so every test case
//using these elements will be updated accordingly if the elements attributes were changed
public class LandingPage {

	public WebDriver driver;
	
	By createBtn = By.cssSelector("a[href='/computers/new']");
	By header = By.xpath("/html/body/header/h1/a");
	By title = By.xpath("/html/body/section/h1");
	By computer = By.xpath("/html/body/section/table/tbody/tr[1]/td[1]/a");
	By computerParent = By.xpath("/html/body/section/table/tbody/tr[1]/td[1]");
	By msg = By.xpath("/html/body/section/div[1]");
	By error = By.cssSelector("[class='clearfix error']");
	By search = By.id("searchbox");
	By search_submit = By.id("searchsubmit");
	By searchError = By.xpath("/html/body/section/div[2]/em");
	By nextList = By.cssSelector("a[href='/computers?p=1']");
	By prevList = By.xpath("/html/body/section/div[2]/ul/li[1]/a");
	By sort = By.xpath("/html/body/section/table/thead/tr/th[1]/a");
	
	public LandingPage(WebDriver newdriver) {
		this.driver = newdriver;
	}
	
	public WebElement getCreateNewBtn() {
		return driver.findElement(createBtn);
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public ComputerPage getComputer() {
		driver.findElement(computer).click();
		ComputerPage cp = new ComputerPage(driver);
		return cp;
	}
	public void getComputerParent() {
		driver.findElement(computerParent).click();;
	}
	public WebElement getMsg() {
		return driver.findElement(msg);
	}
	public LandingPage getError() {
		driver.findElement(error).isDisplayed();
		return this;
	}
	public WebElement getSearchBox() {
		return driver.findElement(search);
	}
	public WebElement getSearchSubmit() {
		return driver.findElement(search_submit);
	}
	public WebElement getSearchError() {
		return driver.findElement(searchError);
	}
	public WebElement getNextList() {
		return driver.findElement(nextList);
	}
	public WebElement gePrevList() {
		return driver.findElement(nextList);
	}
	public WebElement getSort() {
		return driver.findElement(sort);
	}
}
