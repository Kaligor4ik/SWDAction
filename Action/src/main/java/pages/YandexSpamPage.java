package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexSpamPage extends AbstractPage {

	private static final String CONTAINS_TEXT_DRAFT = "//*[contains(text(),'В папке «Спам» нет писем.')]";
	private static final String LETTER_TOPIC = "(//span[@title = 'Danger'])[1]";
	private static final By CHECK_EMPTY = By.xpath(CONTAINS_TEXT_DRAFT);
	private static final By CHECK_TOPIC = By.xpath(LETTER_TOPIC);

	public YandexSpamPage(WebDriver driver) {
		super(driver);
	}

	public boolean spamIsEmpty() {
		return super.isElementPresent(driver.findElement(CHECK_EMPTY));
	}
	
	public boolean currentLetterIsPresent() {
		return super.isElementPresent(driver.findElement(CHECK_TOPIC));
	}
}