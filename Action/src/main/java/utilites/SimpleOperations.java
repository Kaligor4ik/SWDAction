package utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  abstract class SimpleOperations {


	public static boolean isElementPresent(By locator, WebDriver driver) {
		try {
			return driver.findElements(locator).size() > 0;
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public static void setJustTimeOut(int mSec) {
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void clickButton(final By pathButton, WebDriver driver) {
		WebElement button = driver.findElement(pathButton);
		button.click();
	}
}
