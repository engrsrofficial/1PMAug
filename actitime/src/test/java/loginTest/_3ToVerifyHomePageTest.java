package loginTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import _14genericUtility._3BaseClass;

public class _3ToVerifyHomePageTest extends _3BaseClass {
	

	@Test
	public void ToVerifyHomePageTest() throws EncryptedDocumentException, IOException {
		 String expectedTitle = eUtils.fetchDataFromExcelSheets("Sheet2",1,0);
		 
		 wUtils.waitForTitle(driver,"Enter");
		 
		 String actualTitle = driver.getTitle();
		 
		 System.out.println(actualTitle);
		 System.out.println(expectedTitle);
		 
		 AssertJUnit.assertEquals(actualTitle, expectedTitle);
		 System.out.println("PASS: The title is Verified");
	}
	

}
 