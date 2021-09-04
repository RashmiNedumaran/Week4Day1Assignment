package Week4Day1Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("w6hnF2FRhwLC");
		driver.findElement(By.id("sysverb_login")).click();
			//driver.switchTo().defaultContent();
			 WebElement incident = driver.findElement(By.name("filter"));
			 incident.sendKeys("incident");
			 incident.sendKeys(Keys.ENTER);
			 driver.findElement(By.xpath("(//div[text() = 'All'])[2]")).click();
			 
			 driver.switchTo().frame("gsft_main");
			 driver.findElement(By.xpath("(//button[text() ='New'])")).click();
			 driver.findElement(By.id("lookup.incident.caller_id")).click();
			 Set<String> windowshandleSet = driver.getWindowHandles();
			 List<String> windowshandleList = new ArrayList <String>(windowshandleSet);
			 driver.switchTo().window(windowshandleList.get(1));
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("(//a[text()='Abraham Lincoln'])")).click();
			 
			 driver.switchTo().window(windowshandleList.get(0));
			 driver.switchTo().defaultContent();
			 driver.switchTo().frame("gsft_main");
			 driver.findElement(By.id("incident.short_description")).sendKeys("Description");
		String text = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(text);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[text()='Submit'])")).click();
WebElement search = driver.findElement(By.xpath("(//input[@class = 'form-control'])"));
search.sendKeys(text);
search.sendKeys(Keys.ENTER);

//WebElement text2 = driver.findElement(By.className("linked formlink"));
WebElement text2 = driver.findElement(By.xpath("(//a[@class='linked formlink'])"));
text2.getText();
text2.sendKeys(Keys.ENTER);

if(text.equals(text2)){
	System.out.println("search result matches");
}
	else {
		System.out.println("search result not matched");
	}
}

	}
