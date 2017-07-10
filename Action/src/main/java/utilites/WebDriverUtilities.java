package utilites;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverUtilities {

	private WebDriver driver;
	
	public void setDriver(String browser, Platform platform) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(browser);
		capabilities.setPlatform(platform);
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			System.out.println("Webdriver for " + browser + " installed");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public static Platform choosePlatform(String platform) {
		Platform pl = null;
		switch (platform) {
		case "WINDOWS":
			pl = Platform.WINDOWS;
			break;
		case "ANY_PLATFORM":
			pl = Platform.ANY;
			break;
		}
		return pl;
	}
}
