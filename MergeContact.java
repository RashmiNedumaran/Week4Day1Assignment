package Week4Day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver=new ChromeDriver();
			// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
			driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     //2. Enter UserName and Password Using Id Locator
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	// 3. Click on Login Button using Class Locator
	driver.findElement(By.className("decorativeSubmit")).click();
	// 4. Click on CRM/SFA Link
	driver.findElement(By.partialLinkText("CRM/SFA")).click();
    // 5. Click on contacts Button 
	driver.findElement(By.linkText("Contacts")).click();
	// 6. Click on Merge Contacts using Xpath Locator
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	// 7. Click on Widget of From Contact
	driver.findElement(By.xpath("//input[@name = 'partyIdFrom']/following-sibling :: a")).click();
	// 8. Click on First Resulting Contact
	Set <String> windowhandlesSet = driver.getWindowHandles();
	List<String> windowhandlesList = new ArrayList<String>(windowhandlesSet);
	driver.switchTo().window(windowhandlesList.get(1));
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	
	// 9. Click on Widget of To Contact
	driver.switchTo().window(windowhandlesList.get(0));
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//input[@name = 'partyIdTo']/following-sibling :: a")).click();
	
	// 10. Click on Second Resulting Contact
	Set <String> windowhandlesSet1 = driver.getWindowHandles();
	List<String>windowhandlesList1 = new ArrayList<String>(windowhandlesSet1);
	driver.switchTo().window(windowhandlesList1.get(1));
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
	
	//11. Click on Merge button using Xpath Locator
	driver.switchTo().window(windowhandlesList.get(0));
	System.out.println(driver.getTitle());
	//driver.findElement(By.xpath("//a(text()='Merge')")).click();
	driver.findElement(By.className("buttonDangerous")).click();
	
	//  12. Accept the Alert
	Alert alert = driver.switchTo().alert();
	Thread.sleep(2000);
	alert.accept();
	
	// 13. Verify the title of the page
	System.out.println(driver.getTitle());
	}

}
