package javascript_executors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilites.SimpleOperations;

public class JavaScriptTools {

	public static void highlightWithJS(WebElement element, WebDriver driver) {
		String bg = element.getCssValue("backgroundColor");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = 'red'", element);
		SimpleOperations.setJustTimeOut(2000);
		js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
		SimpleOperations.setJustTimeOut(1000);
	}
	
	public static void clickWriteButton(WebElement element, WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
}
