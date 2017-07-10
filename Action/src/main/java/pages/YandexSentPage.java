package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexSentPage extends AbstractPage {

	public YandexSentPage(WebDriver chrome) {
		super(chrome);
	}

	private static final String CHECKBOX = "//span[@class = 'checkbox_view'][1]";
	private static final String DELETE = "//div[@class = 'ns-view-container-desc']/div[6]";
	private static final String CONTAINS_TEXT_SENT = "//*[contains(text(),'В папке «Отправленные» нет писем.')]";

	@FindBy(xpath = CHECKBOX)
	private WebElement checkBox;

	@FindBy(xpath = DELETE)
	private WebElement delBtn;

	@FindBy(xpath = CONTAINS_TEXT_SENT)
	private WebElement emptySentPage;
	
	public boolean isEmptySentPage() {
			return super.isElementPresent(emptySentPage);
	}	
}
