package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YandexNewMessagePage extends AbstractPage {

	public YandexNewMessagePage(WebDriver driver) {
		super(driver);
	}

	private static final String ADRESSEE_FIELD = "(//div[@class = 'mail-Compose-Field-Input']/div)[1]";
	private static final String TOPIC_FIELD = "//input[@name = 'subj']";
	private static final String TEXT_FIELD = "//div[@class='cke_contents cke_reset']/div";
	private static final String SAVE_BUTTON = "//div[@class = '_nb-popup-buttons']/button[1]";
	private static final String DRAFT_BUTTON = "//a[@data-params='fid=6']/span";
	private static final String SEND_LETTER = "//div[@class = 'mail-Compose-Field-Actions-Footer-Main']/div/button";
	                                           //div[@class = 'mail-Compose-Field-Actions-Footer-Main']/div/button
	private static final String LETTER_TOPIC = "(//span[@title = 'Danger'])[1]";
    
	@FindBy(xpath = ADRESSEE_FIELD)
	private WebElement adressee;

	@FindBy(xpath = TOPIC_FIELD)
	private WebElement topic;

	@FindBy(xpath = TEXT_FIELD)
	private WebElement textField;

	@FindBy(xpath = DRAFT_BUTTON)
	private WebElement draftBtn;

	@FindBy(xpath = SAVE_BUTTON)
	private WebElement saveBtn;

	@FindBy(xpath = SEND_LETTER)
	private WebElement sandBtn;
	
	@FindBy(xpath = LETTER_TOPIC)
	private WebElement letterForRewrite;

	public void writeLetter(String adresseeMessage, String topicMessage, String textMessage) {

		adressee.clear();
		adressee.sendKeys(adresseeMessage);

		topic.clear();
		topic.sendKeys(topicMessage);

		textField.clear();
		textField.sendKeys(textMessage);
	}
	
	public void clearTextLetter() {
		textField.clear();
	}

	public void clickDraftAndSaveLetter() {
		draftBtn.click();
		saveBtn.click();
	}

	public YandexDraftPage sendLetter() {
		sandBtn.click();
		draftBtn.click();
		return new YandexDraftPage(driver);
	}
	
//	public void editTextLetter(String myText) throws InterruptedException {	
//		CharSequence text = new String(myText);
//		driver.navigate().refresh();
//		WebElement letterTopic = driver.findElement(By.xpath(LETTER_TOPIC));
//		letterTopic.click();
//		WebElement textField = driver.findElement(By.xpath(TEXT_FIELD));
//		textField.clear();
//		new Actions(driver).sendKeys(textField, text).build().perform();   
//	}
}
