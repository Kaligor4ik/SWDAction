package swd_tests_yandex_mail_page_object;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import pages.YandexCommonPageField;
import pages.YandexDeletedPage;
import pages.YandexSpamPage;

public class ActionWithTargets extends PreparationForTests {
	
	private static final By CHECK_BOX = By.xpath("//span[@class ='_nb-checkbox-flag _nb-checkbox-normal-flag']");

	@BeforeGroups("moveInSpam")
	public void moveTwoLettersInSpam() throws InterruptedException {
		new YandexCommonPageField(driver).openDeletedLetterPage();
		new YandexDeletedPage(driver).selectTwoUpperLettersAndSendToSpam();
		new YandexCommonPageField(driver).openSpamPage();
	}
	
	@BeforeGroups("cleanSpam")
	public void cleanSpam() throws InterruptedException {
		new YandexSpamPage(driver).delAllLetters();
	}

	@Test(priority = 1, groups = {"moveInSpam"})
	public void checkMoveInSpam()  {		
		Assert.assertTrue(new YandexSpamPage(driver).isElementPresent(driver.findElement(CHECK_BOX)), "No empty");
		System.out.println("Test #1 done");
	}

	@Test(priority = 2, groups = { "cleanSpam" }, alwaysRun = true)
	public void checkCleanSpam() {
		driver.navigate().refresh();
		Assert.assertTrue(new YandexSpamPage(driver).spamIsEmpty(), "No empty");
		System.out.println("Test #2 done");
	}
}







//	@Test(priority = 1, groups = { "draggableLetterToDraft" }, alwaysRun = true)
//	public void draggableDeletedLetterToDraft() throws InterruptedException {
//		new YandexDeletedPage(driver).draggableDeletedLetterToSpam();
//		new YandexCommonPageField(driver).openSpamPage();
//		Assert.assertTrue(new YandexSpamPage(driver).currentLetterIsPresent(), "No letter");
//	}
//