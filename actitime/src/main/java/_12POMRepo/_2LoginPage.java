package _12POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _2LoginPage {
	//User Defined Constructor
	public _2LoginPage(WebDriver driver) { //cntl+shift+o
		
		PageFactory.initElements(driver, this);//class, static element
	}
	
	@FindBy(id="username")
	private WebElement usernameTextField;
	
	@FindBy(name="pwd")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	//Business Logic
	public void loginAction(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

	}
