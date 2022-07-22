package com.assign.automation.PageObjects;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.Scenario;

public class HomePageObjects {

	WebDriver driver;
	Scenario scn;
	JavascriptUtil javascriptUtil;
	
	// Variables
		String expURL = "http://automationpractice.com/index.php";
		String expLandingPageTitle = "My Store";
		String expHeightOfLogo = "99";
		String expWidthOfLogo = "350";
		String expSighinPageTitle = "Login - My Store";
		String expTwitterAccName = "Selenium Framework";
		String EmailForSubscribe = "xyzabc123456@gmail.com";
		String ExpProductCatList = "WOMEN DRESSES T-SHIRTS";
		String ExpTwitterAccName = "Selenium Framework";
		
	//Constructor
	public HomePageObjects(WebDriver driver, Scenario scn) {
		this.driver = driver;
		this.scn = scn;
	}
	
	//Page Methods
	public void productategoryValidationTest() {
		List<WebElement> ProductCategoryListLocator = driver
				.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a"));
		System.out.println("Product category list is as below :");
		for (int i = 0; i < ProductCategoryListLocator.size(); i++)  {
			System.out.println((i + 1) + " " + ProductCategoryListLocator.get(i).getText());
			Assert.assertEquals(true, ProductCategoryListLocator.get(i).getText().contains(ExpProductCatList));
		}
		
	}
	
	public void LogoDisplayValidation() {
		WebElement LandingPageLogoLocator = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Assert.assertEquals(true, LandingPageLogoLocator.isDisplayed());
	}
	
	public void logoHeightValidation() {
		WebElement LandingPageLogoLocator = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Assert.assertEquals(true, LandingPageLogoLocator.getCssValue("height").contains(expHeightOfLogo));
	}
	
	public void logoWidthValidation() {
		WebElement LandingPageLogoLocator = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Assert.assertEquals(true, LandingPageLogoLocator.getCssValue("width").contains(expWidthOfLogo));
	}
	
	public void signInPageTitleValidation() throws InterruptedException {
		WebElement SigninBtnLocator = driver.findElement(By.xpath("//a[@class='login']"));
		SigninBtnLocator.click();
		Thread.sleep(4000);
		driver.getTitle();
		Assert.assertEquals(expSighinPageTitle, driver.getTitle());
	}
	
	public void searchBoxEnableValidationAndSuggProductList(String productName) throws InterruptedException {
		WebElement searchBoxLocator = driver.findElement(By.xpath("//input[@name='search_query']"));
		searchBoxLocator.isEnabled();
		Assert.assertEquals(true, searchBoxLocator.isEnabled());
		
		searchBoxLocator.sendKeys(productName);
		Thread.sleep(6000);

		System.out.println("Product category list is as below :");

		List<WebElement> SearchSuggestionsLocator = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
		System.out.println("Search Suggestion list is as below :");
		for (int i = 0; i < SearchSuggestionsLocator.size(); i++) {
			if (SearchSuggestionsLocator.get(i).getText().contains(productName)) {
				System.out.println((i+1) + " " + SearchSuggestionsLocator.get(i).getText());
			}
		}
	}
	
	public void twitterMediaHandleValidation() {
		WebElement twitterLinkLocator = driver.findElement(By.xpath("//section[@id='social_block']/ul//li[@class='twitter']/a"));
		// javascriptUtil.scrollIntoView(twitterLinkLocator, driver);
		twitterLinkLocator.click();
		ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
		String parentWindowId = handles.get(0);
		String childWindowId = handles.get(1);
		driver.switchTo().window(childWindowId);

		WebElement twitterAccNameLocator = driver.findElement(
				By.xpath("//div[@data-testid='UserName']//div[@dir='auto']//span[text()='Selenium Framework']"));
		String twitterAccName = twitterAccNameLocator.getText();
		driver.switchTo().window(parentWindowId);
		Assert.assertEquals(expTwitterAccName, twitterAccName);
	}
	
	public void EnterEmailClickSbmit() {
		WebElement NewsLetterSubLocator = driver.findElement(By.id("newsletter-input"));
		WebElement SubmitBtnLocator = driver.findElement(By.name("submitNewsletter"));
		//javascriptUtil.scrollIntoView(SubmitBtnLocator, driver);
		NewsLetterSubLocator.sendKeys(EmailForSubscribe);
		SubmitBtnLocator.click();
	}
	
	public void NewsletterSubValidation() {
		WebElement NewsLetterSubLocator = driver.findElement(By.id("newsletter-input"));
		WebElement SubmitBtnLocator = driver.findElement(By.name("submitNewsletter"));
		//javascriptUtil.scrollIntoView(SubmitBtnLocator, driver);
		NewsLetterSubLocator.sendKeys(EmailForSubscribe);
		SubmitBtnLocator.click();
		WebElement SubscriptionSucessMsgLocator = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		SubscriptionSucessMsgLocator.getText().contains("Successful");
		Assert.assertEquals(true, SubscriptionSucessMsgLocator.getText().contains("subscribed"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
