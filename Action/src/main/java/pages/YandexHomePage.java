package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javascript_executors.JavaScriptTools;

public class YandexHomePage extends AbstractPage {

	private static final String BUTTON_ENTER_FIELD = "div.domik2__submit>button";
	private static final String PASSWD = "passwd";
	private static final String LOGIN = "login";
	private static final String CONTAINS_TEXT_ENTER = "//*[contains(text(),'Войти')]";
	private static final String CONTEINS_TEXT_ERROR = ".popup__content.auth__error";

	public YandexHomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = LOGIN)
	private WebElement loginInput;

	@FindBy(name = PASSWD)
	private WebElement pwdInput;

	@FindBy(css = BUTTON_ENTER_FIELD)
	private WebElement enterBtn;

	@FindBy(xpath = CONTAINS_TEXT_ENTER)
	private WebElement checkEnterBtn;

	@FindBy(css = CONTEINS_TEXT_ERROR)
	private WebElement checkErrorEmptyEnter;
	
	public YandexCommonPageField loginToYandexMail(String login, String password) {
		
		System.out.println("Login in process...");
		
		JavaScriptTools.highlightWithJS(driver.findElement(By.name(LOGIN)), driver);
		loginInput.clear();
		loginInput.sendKeys(login);
		
		JavaScriptTools.highlightWithJS(driver.findElement(By.name(PASSWD)), driver);
		pwdInput.clear();
		pwdInput.sendKeys(password);
		
		enterBtn.click();
		
		System.out.println("Login done");
		
		return new YandexCommonPageField(driver);	
	}
	
	public boolean checkCorrectLogOut1() {
		return super.isElementPresent(checkEnterBtn);		
	}
	
	public boolean checkCorrectLogOut2() {
		enterBtn.click();
		return super.isElementPresent(checkErrorEmptyEnter);			
	}
}
