package Week4Day1Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExmaple {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 WebElement frame1 = driver.findElement(By.id("frame1"));
		 driver.switchTo().frame(frame1);
		 driver.findElement(By.xpath("(//b[@id = 'topic'])/following::input")).sendKeys("Automation");
		 WebElement Frame2 = driver.findElement(By.id("frame3"));
		 driver.switchTo().frame(Frame2);
		 driver.findElement(By.id("a")).click();
		 driver.switchTo().defaultContent();
		 WebElement frame3 = driver.findElement(By.id("frame2"));
		 driver.switchTo().frame(frame3);
		 driver.findElement(By.xpath("//option[text() = 'Avatar']")).click();
	}

}
