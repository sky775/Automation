package Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjects extends Base {

	//WebDriver driver= initializeDriver();
	
	public pageObjects(WebDriver driver) {           
        this.driver = driver; 
        PageFactory.initElements(driver, this);
}
@FindBy(id="email") WebElement email_loc;	
@FindBy(id="password") WebElement password_loc;
@FindBy(xpath="//button[contains(text(),'Log in')]") WebElement loginbutton;


public void enter_email()
{
	email_loc.sendKeys("neelima.thakur");
}

public void enter_password()
{
	this.password_loc.sendKeys("1234");
}
public void enter_wrong_password()
{
	this.password_loc.sendKeys("12");
}
public void click_on_login()
{
	loginbutton.click();
}






}
