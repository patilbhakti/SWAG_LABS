package com.swagLabsLoginExecutableFile;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SwagLabLogin{
	
	public static WebDriver driver;

	
//Login Page	
	@Given("^launch swag labs application$")
	public void applicationOpen() {
		System.setProperty("webdriver.gaecko.driver", "Browser//gaeckodriver.exe");
		driver=new FirefoxDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	@When("^login to the application with valid or invalid \"([^\"]*)\" and \"([^\"]*)\"$")  
	public void swagLabsLogin(String arg1, String arg2) {
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys(arg1);
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(arg2);
	}
	
	@Then("^validate the error message \"([^\"]*)\" or \"([^\"]*)\" or \"([^\"]*)\"$") 
	public void validateError(String arg1,String arg2,String arg3){
		
		driver.findElement(By.cssSelector("input[id='login-button'][name='login-button']")).click();
		String exp1="Epic sadface: Username and password do not match any user in this service";
		String exp2="Epic sadface: Username is required";
		String exp3="Epic sadface: Password is required";
		WebElement m=driver.findElement(By.cssSelector("div>h3[data-test='error']"));
		String act=m.getText();
		if((act.equals(exp1))||(act.equals(exp2))||(act.equals(exp3))) {
			System.out.println(act);
			driver.close();
		}
		
		
	    
	}
	
	
//Checkout
	@Given("^I want to order an item$")
	public void order() {
		//Add item to the cart
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
		
		//Go to cart
		driver.findElement(By.cssSelector("div>a[class='shopping_cart_link']")).click();
		
		//click checkout
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	}
	
	@When("^validate an information with entering \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void checkout(String firstname, String lastname, String zipcode){
		
		//Enter information
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstname);
		driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(zipcode);
	
	}


	@When("^validate the error message for invalid information \"([^\"]*)\" or \"([^\"]*)\" or \"([^\"]*)\"$")
    public void validateError1(String arg1,  String arg2, String arg3){
		
		driver.findElement(By.cssSelector("input[id='continue'][name='continue']")).click();
			
			String err1="Error: First Name is required";
			String err2="Error: Last Name is required";
			String err3="Error: Postal Code is required";
			
			WebElement err=driver.findElement(By.cssSelector("div>h3[data-test='error']"));
			String actual=err.getText();
			
		if((actual.equals(err1))||(actual.equals(err2))||(actual.equals(err3))){
			System.out.println(actual);
			driver.navigate().back();
	        driver.navigate().back();
		}
		
	}

	@Then ("^order an item with valid information$")
	public void validateCheckout() {

		//Go to cart
		driver.findElement(By.cssSelector("div>a[class='shopping_cart_link']")).click();
		
		//Go to cart
		driver.findElement(By.cssSelector("div>a[class='shopping_cart_link']")).click();
		
		//click checkout
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		//Enter information
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Ria");
		driver.findElement(By.cssSelector("input[id='last-name']")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("560003");
		
		driver.findElement(By.cssSelector("input[id='continue'][name='continue']")).click();
		
		
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Back Home')]")).click();
		
	
	}
	
//Home Page
	@Given("^I am in home page$")
	public void homePage(){
	}

	@When("^validate filters$")
	public void validateFilters(){
		Select filter1= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter1.selectByVisibleText("Name (Z to A)");
		
		Select filter2= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter2.selectByVisibleText("Price (low to high)");
		
		Select filter3= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter3.selectByVisibleText("Price (high to low)");
		
		Select filter4= new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
		filter4.selectByVisibleText("Name (A to Z)");
	    
	}

	@Then("^validate menu options$")
	public void validateMenu(){
		//Add item to cart
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

		//click menu button
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		//
		driver.findElement(By.xpath("//a[@id='inventory_sidebar_link']")).click();
		driver.findElement(By.xpath("//a[contains(@id,'reset_sidebar_link')]")).click();
		driver.findElement(By.xpath("//a[contains(@id,'about_sidebar_link')]")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		driver.findElement(By.xpath("//a[contains(@id,'logout_sidebar_link')]")).click();
	    
	}

}
