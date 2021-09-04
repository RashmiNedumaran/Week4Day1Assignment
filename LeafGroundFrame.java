package Week4Day1Assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Frame1 = driver.findElement(By.xpath("//iframe[@src = 'default.html']"));
		driver.switchTo().frame(Frame1);
		WebElement ScreenShot = driver.findElement(By.id("Click"));
		File source = ScreenShot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/frames.png");
		FileUtils.copyFile(source, destination);
		driver.switchTo().defaultContent(); 
		List<WebElement> Count = driver.findElements(By.tagName("iframe"));
		int size = Count.size();
		System.out.println("The number of frames are " +size);


	}

}
