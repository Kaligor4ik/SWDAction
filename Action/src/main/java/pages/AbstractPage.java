package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import utilites.SimpleOperations;

public abstract class AbstractPage {

	public WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	
	public boolean isElementPresent(WebElement web) {
		try {
			return web.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		}
	}
	
	public void delAllLetters() {	
		new Actions(driver).sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a")).perform();
		SimpleOperations.setJustTimeOut(1);
		new Actions(driver).sendKeys(Keys.chord(Keys.DELETE)).perform();
		System.out.println("Letters deleted");
	}
}
