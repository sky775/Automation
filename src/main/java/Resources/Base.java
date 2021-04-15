package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public Properties p;
	public FileInputStream fs;
	public WebDriver initializeDriver()  {
		// TODO Auto-generated method stub
		
		
		try {
			fs = new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Practice\\src\\main\\java\\Resources\\creds");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p= new Properties();
		try {
			p.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   System.out.print(p.getProperty("browser"));
	   
	  if(p.getProperty("browser").equals("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  
	  }
	  if(p.getProperty("browser")== "firefox")
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		 
	  }
	   return driver;
	}
	
	

}
