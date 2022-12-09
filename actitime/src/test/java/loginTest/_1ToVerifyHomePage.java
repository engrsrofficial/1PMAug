package loginTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _12POMRepo._2LoginPage;
import _12POMRepo._3HomePage;

public class _1ToVerifyHomePage {
	
	public static void main(String[] args) throws IOException {
		//Converting Physical Representation of Property File to Java Representation
		FileInputStream fis=new FileInputStream("./TestData/PropertyData.properties");
		Properties property = new Properties();
		//Loading the keys of the property file
		property.load(fis);
		//calling the value using the key
		String url = property.getProperty("url");
		System.out.println(url);
		
		String username = property.getProperty("username");	
		System.out.println(username);
		
		String password = property.getProperty("password");
		System.out.println(password);
		
		FileInputStream fis1 = new FileInputStream("./TestData/ExcelData2.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String expectedTitle = workbook.getSheet("Sheet2").getRow(1).getCell(0).toString();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
		_2LoginPage login = new _2LoginPage(driver);
		login.loginAction(username,password);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);//explicit Wait - get title
		wait.until(ExpectedConditions.titleContains("Enter"));
		
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass: The Home page is Verified");
			
		}
		else
			System.out.println("Fail: The Home page is not Verified");
		
		_3HomePage home = new _3HomePage(driver);
		home.logoutAction();
		
		driver.quit();
	}
	

}
