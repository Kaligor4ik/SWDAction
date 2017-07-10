package swd_tests_yandex_mail_page_object;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.YandexHomePage;
import utilites.WebDriverUtilities;

public abstract class PreparationForTests {
	
	private static final int TIMEOUT = 10;
	private static final String START_URL = "http://yandex.ru";
	private static final String PASSWORD = "kaligor1990";
	private static final String LOGIN = "Kaligorka007";
	protected WebDriver driver;
	
	WebDriverUtilities webDriwer = new WebDriverUtilities();
	
	@BeforeClass
	@Parameters({"browser", "platform"})  
	public void setDriver(@Optional String browser, String platform) {	
		webDriwer.setDriver(browser, WebDriverUtilities.choosePlatform(platform));
	}		
	
	@BeforeClass(dependsOnMethods = "setDriver")
	public void startBrowser() {
		driver = webDriwer.getDriver();
		driver.get(START_URL);
		setTimeoutAndMaxSizeWindow(TIMEOUT);
		new YandexHomePage(driver).loginToYandexMail(LOGIN, PASSWORD);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		webDriwer.getDriver().quit();
    }
	
	private void setTimeoutAndMaxSizeWindow(int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
}
