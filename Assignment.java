package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Assignment
{
	Actions action;
	public Assignment(WebDriver driver)
	{
		action= new Actions(driver);
	}
	public void pressEnter(WebDriver driver)
	{
		action.sendKeys(Keys.ENTER).build().perform();
	}
	public void performMouseHover(WebElement element)
	{
	    action.moveToElement(element).build().perform();	
	}
	public void click(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void main(String[] args) throws Exception 
	{
		
				System.setProperty("webdriver.chrome.driver","//Applications//chromedriver");
				
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Assignment obj= new Assignment(driver);
				driver.get("");
				System.out.println(driver.getTitle());
				driver.manage().window().maximize();
				List<WebElement> labels= driver.findElements(By.xpath(""));
				WebElement e;
				for(int i=0;i<labels.size();i++)
				{
					e= labels.get(i);
					System.out.println(e.getText());
				}
				driver.findElement(By.id("Fiction_Id")).click();
				String st = driver.getTitle();
				String st1 = "Fiction";
				if(st1.equalsIgnoreCase(st1))
				{
					System.out.println("Test SuccessFul");
				}
				else
				{
					System.out.println("Test Failure");
				}
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,2000)");
				WebElement inputSearch= driver.findElement(By.xpath(""));
				inputSearch.sendKeys("Charles Dickens");
				obj.pressEnter(driver);
				
				String SelectLinkNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
				driver.findElement(By.linkText("GREAT EXPECTATIONS")).sendKeys(SelectLinkNewTab);
				String SelectLinkNewTab1 = Keys.chord(Keys.CONTROL,Keys.RETURN);
				driver.findElement(By.partialLinkText("GREAT")).sendKeys(SelectLinkNewTab1);
				ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				
				driver.findElement(By.id("Alertbox")).isDisplayed();
				Alert alertBox= driver.switchTo().alert();
				System.out.println(alertBox.getText());
				Thread.sleep(2000);
				alertBox.accept();
				Thread.sleep(2000);
				driver.close();
				
		       
	}

	

}
