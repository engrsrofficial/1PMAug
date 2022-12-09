package _12POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _3HomePage {//Naming Convention

	public _3HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="logoutLink")
	private WebElement logoutButton;
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	public void logoutAction() {
		logoutButton.click();
	}

}
