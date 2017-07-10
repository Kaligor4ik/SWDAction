package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import javascript_executors.JavaScriptTools;

public class YandexCommonPageField extends AbstractPage {

	public YandexCommonPageField(WebDriver driver) {
		super(driver);
	}

	private static final String SENT_PAGE_BUTTON = "//a[@data-params='fid=4']/span";
	private static final String DRAFT_PAGE_BUTTON = "(//span[@class = 'mail-NestedList-Item-Name js-folders-item-name'])[5]";
	private static final String DELETE_PAGE_BUTTON = "//a[@data-params='fid=3']/span";
	private static final String SPAM_PAGE_BUTTON = "//a[@data-params='fid=2']/span";
	private static final String USER_MENU = "//div[@class = 'mail-User-Name']";
    private static final String EXIT = "//div[@class = 'b-mail-dropdown__item'][6]/a";
    private static final String USER_NAME_FIELD = "//div[@class='mail-User-Name']['Kaligorka007']";
	private static final String WRITE_BUTTON = "//div[@class = 'mail-ComposeButton-Wrap']/a";
													
	@FindBy(xpath = USER_NAME_FIELD)
	private WebElement yourUserName;

	@FindBy(xpath = WRITE_BUTTON)
	private WebElement writeBtn;
    
    @FindBy(xpath = SENT_PAGE_BUTTON)
  	private WebElement fieldSentLetter;
    
    @FindBy(xpath = DRAFT_PAGE_BUTTON)
  	private WebElement fieldDraftLetter;
    
    @FindBy(xpath = DELETE_PAGE_BUTTON)
  	private WebElement fieldDeleteLetter;
    
    @FindBy(xpath = SPAM_PAGE_BUTTON)
  	private WebElement fieldSpam;
    
    @FindBy(xpath = USER_MENU)
  	private WebElement fieldUserMenu;
    
    @FindBy(xpath = EXIT)
  	private WebElement fieldExit;
    
    public YandexHomePage logOut() {
    	fieldUserMenu.click();
    	fieldExit.click();	
    	return new YandexHomePage(driver);
	}
    
    public YandexSentPage openSentLetterPage() {
    	fieldSentLetter.click();
		return new YandexSentPage(driver);		
	}
    
    public YandexDeletedPage openDeletedLetterPage() {
    	fieldDeleteLetter.click();
    	return new YandexDeletedPage(driver);		
	}    

	public YandexDraftPage openDraftPage() {
    	fieldDraftLetter.click();
		return new YandexDraftPage(driver);		
	}
	
	public YandexSpamPage openSpamPage() {
    	fieldSpam.click();
		return new YandexSpamPage(driver);		
	}
    
	public YandexNewMessagePage clickWriteButton() {
		JavaScriptTools.clickWriteButton(writeBtn, driver);
		return new YandexNewMessagePage(driver);
	}  
	
	public boolean userNameIsCorrect() {
		return super.isElementPresent(yourUserName);
	}
}
