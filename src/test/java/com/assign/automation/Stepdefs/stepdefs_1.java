package com.assign.automation.Stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assign.automation.PageObjects.HomePageObjects;
import com.assign.automation.PageObjects.JavascriptUtil;
import com.assign.automation.Stepdefs.stepdefs_1;
import com.assign.automation.core.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefs_1 {

	private static final Logger logger = LogManager.getLogger(stepdefs_1.class);

	WebDriver driver;
	String URL = "http://automationpractice.com/index.php";
	int implicitWait_Timeout_sec = 20;

	Scenario scn;

	JavascriptUtil javascriptUtil;
	HomePageObjects homePageObjects;

	@Before
	public void setUp(Scenario scn) throws Exception {
		this.scn = scn;
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		logger.info("Browser invoked.");

		homePageObjects = new HomePageObjects(driver, scn);
	}

	@After(order = 1)
	public void cleanUp() {
		driver.quit();
		logger.info("Browser closed");
		scn.log("Browser Closed");
	}

	@After(order = 2)
	public void takeScreenShot(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot) driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "Failed Step Name: " + s.getName());
		} else {
			scn.log("Test case is passed, no screen shot captured");
		}
	}

	@Given("User opened home page URL")
	public void user_is_able_to_launch_url() {
		driver.get(URL);
		String expURL = "http://automationpractice.com/index.php";
		logger.info("Browser navigated to URL: " + URL);
		scn.log("Browser navigated to URL: " + URL);
		Assert.assertEquals(expURL, driver.getCurrentUrl());
	}

	@Then("Landing page title should be {string}")
	public void landing_page_title_should_be(String string) {
		String expLandingPageTitle = "My Store";
		Assert.assertEquals(expLandingPageTitle, driver.getTitle());
		logger.info("Landing page title is validated and actual title is: " + driver.getTitle());
		scn.log("Landing page title is validated and actual title is: " + driver.getTitle());

	}

	@Then("Access the Product category list")
	public void access_the_product_category_list() {
		homePageObjects.productategoryValidationTest();
		logger.info("Product category list validated with actual list");
		scn.log("Product category list validated with actual list");

	}

	@Then("Logo displayed")
	public void logo_is_displayed() {
		homePageObjects.LogoDisplayValidation();
		logger.info("Logo displayed on Home page");
		scn.log("Logo displayed on Home page");
	}

	@Then("Height of the logo should be {string}")
	public void height_of_the_logo_should_be(String expHeightOfLogo) {
		homePageObjects.logoHeightValidation();
		logger.info("Logo Height is validated as" + expHeightOfLogo);
		scn.log("Logo Height is validated as" + expHeightOfLogo);
	}

	@Then("Width of the logo should be {string}")
	public void width_of_the_logo_should_be(String expWidthOfLogo) {
		homePageObjects.logoWidthValidation();
		logger.info("Logo Width is validated as" + expWidthOfLogo);
		scn.log("Logo Width is validated as" + expWidthOfLogo);
	}

	@Then("User click on the Sign in button and SignIn page title should be {string}")
	public void sign_in_page_title_should_be(String expSighinPageTitle) throws InterruptedException {
		homePageObjects.signInPageTitleValidation();
		scn.log("SignIn page title is as expected");
	}

	@Then("Suggested search list is displayed when entered {string}")
	public void suggested_search_list_is_displayed_when_entered(String productName) throws InterruptedException {
		homePageObjects.searchBoxEnableValidationAndSuggProductList(productName);
		scn.log("Suggested search list is displayed as expected");
	}

	@When("User click on the Twitter link from bottom of the landing page")
	public void user_click_on_the_twitter_link_from_bottom_of_the_landing_page() {
		WebElement twitterLinkLocator = driver.findElement(By.xpath("//section[@id='social_block']/ul//li[@class='twitter']/a"));
		twitterLinkLocator.click();
	}

	@Then("User is able to navigate to the Twitter social media handle account")
	public void user_is_able_to_navigate_to_the_twitter_social_media_handle_account() {
		homePageObjects.twitterMediaHandleValidation();
		scn.log("User is able to navigate to the Twiter account");
	}

	@When("User entered Email and user click on the submit button")
	public void user_entered_email_and_user_click_on_the_submit_button() {
		homePageObjects.EnterEmailClickSbmit();
		
	}

	@Then("User is able to subscribe the Newsletter")
	public void user_is_able_to_subscribe_the_newsletter() {
		homePageObjects.NewsletterSubValidation();
		scn.log("Newsletter subscription is validated");
	}

}
