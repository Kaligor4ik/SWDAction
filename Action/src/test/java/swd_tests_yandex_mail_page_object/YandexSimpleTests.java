package swd_tests_yandex_mail_page_object;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import data.TestDataProvider;
import pages.YandexHomePage;
import pages.YandexCommonPageField;
import pages.YandexNewMessagePage;
import pages.YandexDraftPage;
import pages.YandexSentPage;
import utilites.SimpleOperations;

public class YandexSimpleTests extends PreparationForTests {

	@BeforeGroups("checkSentMessages")
	public void enterSentLetterPage() {
		new YandexCommonPageField(driver).openSentLetterPage();
		System.out.println("Entry to the 'Sent' page");
	}

	@BeforeGroups("checkDeleteAllMessages")
	public void deleteAllLetters() {
		new YandexSentPage(driver).delAllLetters();
		System.out.println("Delete letters in process...");
	}

	@BeforeGroups("checkLogout")
	public void logoutFromYandexMail() {
		new YandexCommonPageField(driver).logOut();
		System.out.println("Logout in process...");
	}

	@Test(priority = 1, groups = { "checkLoginToYandex" }, alwaysRun = true)
	public void checkLoginToYandex() {
		Assert.assertTrue(new YandexCommonPageField(driver).userNameIsCorrect(), "Not logged");
		System.out.println("Login was completed correctly.");
	}

	@Test(priority = 2, groups = {
			"writeSaveLetter" }, dataProviderClass = TestDataProvider.class, dataProvider = "loadUserDataFromFile", alwaysRun = true)
	public void checkWriteSaveLetter(String... data) {
		new YandexCommonPageField(driver).clickWriteButton();
		new YandexNewMessagePage(driver).writeLetter(data[0], data[1], data[2]);
		new YandexNewMessagePage(driver).clickDraftAndSaveLetter();
		Assert.assertTrue(SimpleOperations.isElementPresent(
				By.xpath(String.format("%s%s%s", "//span[@title = '", data[1], "'][1]")), driver), "Letter not saved!");
		System.out.println("Letter saved.");
	}

	@Test(priority = 3, groups = {
			"sendAllLetters" }, dataProviderClass = TestDataProvider.class, dataProvider = "loadUserDataFromFile", alwaysRun = true)
	public void checkSendCurrentLetter(String... data) {
		SimpleOperations.clickButton(By.xpath(String.format("%s%s%s", "//span[@title = '", data[1], "'][1]")), driver);
		new YandexNewMessagePage(driver).sendLetter();
		SimpleOperations.setJustTimeOut(3000);
		driver.navigate().refresh();
		Assert.assertFalse(SimpleOperations.isElementPresent(
				By.xpath(String.format("%s%s%s", "//span[@title = '", data[1], "'][1]")), driver), "Letter not sent!");
		System.out.println("Letter with topic " + data[1] + " is sent");
	}

	@Test(priority = 4, groups = { "sendAllLetters" }, alwaysRun = true)
	public void checkSendAllLetter() {
		Assert.assertTrue(new YandexDraftPage(driver).allLetterIsSent());
		System.out.println("All letters sent.");
	}

	@Test(priority = 5, groups = "checkSentMessages", dataProviderClass = TestDataProvider.class, dataProvider = "loadUserDataFromFile", alwaysRun = true)
	public void checkSentMessages(String... data) {
		Assert.assertTrue(
				SimpleOperations.isElementPresent(By.cssSelector(String.format("%s%s%s", "[title = '", data[1], "']")), driver),
				String.format("Letter '%s' not sent!", data[1]));
		System.out.println("Letter" + data[1] + " sent.");
	}

	@Test(priority = 6, groups = "checkDeleteAllMessages", alwaysRun = true)
	public void checkDeleteAllLetter() {
		Assert.assertTrue(new YandexSentPage(driver).isEmptySentPage(), "Letters not deleted");
		System.out.println("All letters deleted");
	}

	@Test(priority = 7, groups = "checkLogout", alwaysRun = true)
	public void checkLogOut1() {
		Assert.assertTrue(new YandexHomePage(driver).checkCorrectLogOut1(), "Logout not done!");
		System.out.println("Exit done");
	}

	@Test(priority = 8, groups = "checkLogout", alwaysRun = true)
	public void checkLogOut2() {
		Assert.assertTrue(new YandexHomePage(driver).checkCorrectLogOut2(), "Logout not done!");
		System.out.println("Exit done");
	}
}
