package Tests;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Resources.Base;
import Resources.pageObjects;
public class LoginTest extends Base {
	public WebDriver driver = initializeDriver();
	pageObjects po = new pageObjects(driver);
	@Test
	
	public void login_successfull()
	{
		//pageObjects pobj= new pageObjects(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
		po.enter_email();
		po.enter_password();
		po.click_on_login();	
		Assert.assertEquals("Shekhar", "Yadav");
	}
	
	@Test
	public void wrong_credentials() throws MalformedURLException, IOException
	{
		String url=p.getProperty("url");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(p.getProperty("url"));
		po.enter_email();
		po.enter_wrong_password();
		po.click_on_login();
		URL u= new URL(url);
		HttpURLConnection huc = (HttpURLConnection)u.openConnection();
		
        
        huc.setRequestMethod("HEAD");
        
        huc.connect();
        
        int respCode = huc.getResponseCode();
		
		 // System.out.print(url);
		  System.out.print(respCode);
		 
        Assert.assertEquals(404, respCode);
		
	}
}
