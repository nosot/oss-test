import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.SelectorMethod

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.testng.asserts.SoftAssert
import com.kms.katalon.core.testdata.CSVData
import org.openqa.selenium.Keys as Keys

SoftAssert softAssertion = new SoftAssert();
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("http://dv2kkeser.web1day.com/public/oss/backend/template/menu/1363")
int linkcount = 1
int count = 1
selenium.click("link=" + linkcount)
while (count<400) {
selenium.click("xpath=//tr[" + count + "]/td[3]/button[2]/i")
selenium.click("xpath=//button[@id='dowbload-file']/i")
Thread.sleep(1500);
selenium.click("xpath=//div[@id='editmyModal']/div/div/div[3]/button")
Thread.sleep(1500);
count = selenium.getEval(" var linkcount = \"" + linkcount + "\";var count = \"" + count + "\";var storedVars = { 'linkcount': linkcount,'count': count }; " + count + "+1").toInteger()
if (count.toString() == 11) {
linkcount = selenium.getEval(" var linkcount = \"" + linkcount + "\";var count = \"" + count + "\";var storedVars = { 'linkcount': linkcount,'count': count }; " + linkcount + "+1").toInteger()
selenium.click("link=" + linkcount)
count = selenium.getEval(" var linkcount = \"" + linkcount + "\";var count = \"" + count + "\";var storedVars = { 'linkcount': linkcount,'count': count }; " + count + "-10").toInteger()
}
}
