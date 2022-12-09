package _14genericUtility;//Configuration Annotation

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import _12POMRepo._2LoginPage;
import _12POMRepo._3HomePage;

public class _3BaseClass {
	public WebDriver driver;
	public _1FileUtility fUtils = new _1FileUtility();
	public _2excelUtility eUtils = new _2excelUtility();
	public _4WebDriverUtility wUtils=new _4WebDriverUtility();
	@BeforeSuite //Connect to database
	public void bsConfig() { //Annotations will only run when you provide variables/methods
		System.out.println("connect to Database"); //Advanced Selenium Concept
	}
	@BeforeClass //Launch the browser and Navigate to URL
	public void bcConfig() throws IOException
	{
		String url = fUtils.fetchDataFromPropertyFile("url");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	@BeforeMethod //Login to Application
	public void bmConfig() throws IOException
	{
		String username = fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		_2LoginPage login = new _2LoginPage(driver);
		login.loginAction(username, password);
	} //Pre Condition Over
	
	//@Test will Run (Actual Test Case) - Verify the home page, Add the customer
	
	@AfterMethod // Code to Logout
	public void amConfig() 
	{
		_3HomePage home = new _3HomePage(driver);
		home.logoutAction();
	}
	@AfterClass //
	public void acConfig()
	{
		driver.quit();
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("data base is closed");	
	}
}
