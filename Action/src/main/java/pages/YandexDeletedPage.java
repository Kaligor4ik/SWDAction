package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class YandexDeletedPage extends AbstractPage {

	private static final By CHECK_BOX = By.cssSelector("._nb-checkbox-flag._nb-checkbox-normal-flag");
	private static final By DROPLIST_PAGES = By.xpath("(//*[contains(text(),'В папку')])[1]");
	private static final By DROPLIST_SPAM_PAGE = By.xpath("(//span[@class = 'b-folders__folder__name']/a)[4]");

	public YandexDeletedPage(WebDriver driver) {
		super(driver);
	}

	public void selectTwoUpperLettersAndSendToSpam() throws InterruptedException {
		List<WebElement> listItems = driver.findElements(CHECK_BOX);
		System.out.println("Item list size: " + listItems.size());
		new Actions(driver).clickAndHold(listItems.get(0)).moveToElement(listItems.get(1)).moveByOffset(90, 0).release()
				.perform();
		System.out.println("Letters marked");
		driver.findElement(DROPLIST_PAGES).click();	
		driver.findElement(DROPLIST_SPAM_PAGE).click();
		System.out.println("Letters sent to Spam");
	}
}











// private static final By LETTER_TOPIC = By.xpath("(//span[@title =
// 'Danger'])[1]");
// private static final By SPAM_PAGE_BUTTON = By.xpath("(//span[@class =
// 'mail-NestedList-Item-Name js-folders-item-name'])[4]");

// public void draggableDeletedLetterToSpam() throws InterruptedException {
// WebElement source = driver.findElement(LETTER_TOPIC);
// WebElement target = driver.findElement(SPAM_PAGE_BUTTON);
// new Actions(driver).dragAndDrop(source, target).build().perform();
// }