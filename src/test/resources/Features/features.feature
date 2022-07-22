@ui 
Feature: Project website health Check
Background: Navigation to the URL
    
	@Test1 
    Scenario: URL redirection test
    Given User opened home page URL
    
 	@Test2
   Scenario: Landing page title test
     When User opened home page URL
     Then Landing page title should be "LandingPageTitle"
     
  @Test3 
    Scenario: Product category list validation
    	When User opened home page URL
    	Then  Access the Product category list
    	
  @Test4
  	Scenario: Landing page application logo
  		When User opened home page URL
  		Then Logo displayed
  		
	@Test5
		Scenario: Application logo Height
		 Given User opened home page URL
			Then Height of the logo should be "99"
			
  @Test6
		Scenario: Application logo width 
		 Given User opened home page URL
			When Logo displayed
			Then Width of the logo should be "350"
		
	
	@Test7
		Scenario: signin page and title validation
	    When User opened home page URL
			Then User click on the Sign in button and SignIn page title should be "Login - My Store"
			
	@Test8
		Scenario Outline: Search product by keywords and check the suggested list
		Given User opened home page URL
     And Suggested search list is displayed when entered "<productName>"
    Examples: 
      | productName |
      | Dress       |
		
	
	@Test9
		Scenario: Validate Twitter social media handle account
		Given User opened home page URL 
		 When User click on the Twitter link from bottom of the landing page 
			Then User is able to navigate to the Twitter social media handle account
			
	@Test10
		Scenario: Subscribe the Newsletter
		 Given User opened home page URL
			When User entered Email and user click on the submit button 
			Then User is able to subscribe the Newsletter
				
