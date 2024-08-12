package mymagentoTest;



import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MagentoTest {
	WebDriver driver=new ChromeDriver();
	String myWebsite ="https://magento.softwaretestingboard.com/";
	Random rand = new Random();
	String password = "Mm102mdma";
	String emailAddressLogin = "";
	String logoutPage = "https://magento.softwaretestingboard.com/customer/account/logout/";
	
	@BeforeTest
	public void mysetup() {
		driver.get(myWebsite);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	
	}
	
	
	@Test(priority = 1,enabled=false)
	public void creatAnAccount() {
		WebElement creatAccountpage=driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
		creatAccountpage.click();
		String[] first_Names = { "Alice", "Bob", "Charlie", "David", "Eve", "Fay", "Grace" };
		String[] Last_Names = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia" };
		int randomIndexFortheFirstname= rand.nextInt(first_Names.length);
		int randomIndexForthelastname= rand.nextInt(Last_Names.length);
		
		WebElement firstNameInput = driver.findElement(By.id("firstname"));
		WebElement lastNameInput = driver.findElement(By.id("lastname"));
		WebElement emailAddressInput = driver.findElement(By.id("email_address"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
		WebElement createAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		
		String firstname = first_Names[randomIndexFortheFirstname];
		String lastname = Last_Names[randomIndexForthelastname];
		int randomnumber = rand.nextInt(9876);
		String domainName = "@gmail.com";
		
		
		firstNameInput.sendKeys(firstname);
		lastNameInput.sendKeys(lastname);
		emailAddressInput.sendKeys(firstname + lastname + randomnumber + domainName);
		passwordInput.sendKeys(password);
		confirmPassword.sendKeys(password);
		createAccountButton.click();	
		emailAddressLogin = firstname + lastname + randomnumber + domainName;
		
		WebElement messageASwebElement = driver.findElement(By.className("messages"));
		String TheActualMessage = messageASwebElement.getText();
		String TheExpectedMessage = "Thank you for registering with Main Website Store.";
		
		Assert.assertEquals(TheActualMessage, TheExpectedMessage);
		
		
	}
	
	@Test(priority = 2,enabled=false)
	public void logOut() {
	
		driver.get(logoutPage);	
		WebElement logoutMessag = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
		String actualMsg = logoutMessag.getText();
		String expectedMsg = "You are signed out";
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}
	
	@Test(priority = 3,enabled=false)
	public void loginTest() {
		
		WebElement LoginPage = driver.findElement(By.linkText("Sign In"));
		LoginPage.click();

		WebElement EmailLoginInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement LoginButton = driver.findElement(By.cssSelector(".action.login.primary"));
		
		EmailLoginInput.sendKeys(emailAddressLogin);
		passwordInput.sendKeys(password);
		
		LoginButton.click();
		
		String welcomeMsg = driver.findElement(By.className("logged-in")).getText();
		
		boolean Actualvalue = welcomeMsg.contains("Welcome");
		boolean ExpectedValue = true;
		
		Assert.assertEquals(Actualvalue, ExpectedValue);
		
		
	}
	
	@Test(priority = 4,enabled=false)
	public void addMenItem() {
		
		WebElement MenSection=driver.findElement(By.id("ui-id-5"));
		MenSection.click();
		WebElement productItemsContainer=driver.findElement(By.className("product-items"));
		List<WebElement> AllItems =productItemsContainer.findElements(By.tagName("li"));
		int TotalNumberOfItems = AllItems.size();
		int randomItem = rand.nextInt(TotalNumberOfItems);
		AllItems.get(randomItem).click();
		
		WebElement theContainerOfSizes=driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
		List<WebElement> listOfZizes=theContainerOfSizes.findElements(By.className("swatch-option"));
		int numberOfsizes =listOfZizes.size();
		int randomSize = rand.nextInt(numberOfsizes);
		listOfZizes.get(randomSize).click();
		
		WebElement colorsContainer = driver.findElement(By.cssSelector("div[class='swatch-attribute color']"));
		List <WebElement> listOfColors = colorsContainer.findElements(By.tagName("div"));
		int numberOfColors = listOfColors.size();
		int randomColor = rand.nextInt(numberOfColors);
		listOfColors.get(randomColor).click();
		
		WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));
		AddToCartButton.click();
		
		WebElement MessageAdded = driver.findElement(By.className("message-success"));
		
		System.out.println(MessageAdded.getText().contains("You added "));
		
		Assert.assertEquals(MessageAdded.getText().contains("You added "),true);
		
		
		
		
		
	}
	
	
	@Test(priority = 5) 
	public void womwnTest () throws InterruptedException {
		
	WebElement WomenSection = driver.findElement(By.id("ui-id-4"));
	WomenSection.click();
	WebElement ItemsContainer = driver.findElement(By.className("product-items"));
	List<WebElement> listOfItem = ItemsContainer.findElements(By.tagName("li"));
	 int numOfItem = listOfItem.size();
	 int randomItem = rand.nextInt(numOfItem);
	 listOfItem.get(randomItem).click();
		
	 WebElement theSizes = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));
	 List <WebElement> listOfsizes = theSizes.findElements(By.className("swatch-option"));
	 int numberOfsizes =listOfsizes.size(); 
	 int randomSize = rand.nextInt(numberOfsizes);
	 listOfsizes.get(randomSize).click();
	 
	 WebElement colorsContainer = driver.findElement(By.cssSelector("div[class='swatch-attribute color']"));
		List <WebElement> listOfColors = colorsContainer.findElements(By.tagName("div"));
		int numberOfColors = listOfColors.size();
		int randomColor = rand.nextInt(numberOfColors);
		listOfColors.get(randomColor).click();
		
		WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));
		AddToCartButton.click();
		
		WebElement MessageAdded = driver.findElement(By.className("message-success"));
		
		System.out.println(MessageAdded.getText().contains("You added "));
		
		Assert.assertEquals(MessageAdded.getText().contains("You added "),true);
		
		
		driver.navigate().refresh();
		
		WebElement ReviewSEction = driver.findElement(By.id("tab-label-reviews-title"));
		ReviewSEction.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1200)");
		
		Thread.sleep(2000);
	 
		WebElement RatingStars = driver.findElement(By.cssSelector(".control.review-control-vote"));
		Thread.sleep(2000);
		
		System.out.println(RatingStars.findElements(By.tagName("label")).size() + "********");
		String[] ids = { "Rating_1", "Rating_2", "Rating_3", "Rating_4", "Rating_5" };
		int randomIndex = rand.nextInt(ids.length);
		WebElement element = driver.findElement(By.id(ids[randomIndex]));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		
		 WebElement nickname = driver.findElement(By.id("nickname_field"));
		 nickname.sendKeys("Mohammed");
		
		 WebElement summary = driver.findElement(By.id("summary_field"));
         summary.sendKeys("mo 3ajbetne albda3a");
         
         WebElement review = driver.findElement(By.id("review_field"));
         review.sendKeys("hello this is a test");
	 
          WebElement submitReviewButton = driver.findElement(By.cssSelector(".action.submit.primary"));
          submitReviewButton.click();
          
          String actualTextforReview = driver.findElement(By.cssSelector(".message-success.success.message")).getText();
  		  String expectedTextforReview = "You submitted your review for moderation.";

  		 Assert.assertEquals(actualTextforReview, expectedTextforReview);
	}
	
	
	

}
