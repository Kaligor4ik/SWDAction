package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexDraftPage extends AbstractPage {

	private static final String CONTAINS_TEXT_DRAFT = "//*[contains(text(),'В папке «Черновики» нет писем.')]";
	private static final By CHECK_EMPTY = By.xpath(CONTAINS_TEXT_DRAFT);

	public YandexDraftPage(WebDriver driver) {
		super(driver);
	}

	public boolean allLetterIsSent() {
		return super.isElementPresent(driver.findElement(CHECK_EMPTY));
	}
}
