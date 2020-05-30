package ProjectAdmin.TestAutomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launchchrome {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/Users/priyankarachamalla/Downloads/webdrivers/geckodriver");
		driver =  new FirefoxDriver();
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.linkText("App Store")).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());
		List<String> windowlist = new ArrayList<String>(handles);
		String parentwindowID= windowlist.get(0);
		String childwindowid=windowlist.get(1);
		System.out.println(parentwindowID);
		System.out.println(childwindowid);
		driver.switchTo().window(parentwindowID);
		Thread.sleep(5000);
		System.out.println("Im in parent window ");
		driver.switchTo().window(childwindowid);
		System.out.println("in child window");
		System.out.println(driver.getCurrentUrl());
		WebElement watch= driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-watch']"));
		System.out.println(watch.getText());
        watch.click();
        driver.switchTo().window(parentwindowID);
        Thread.sleep(5000);
        System.out.println("i moved again to parent window");
     
		
		
	}
	

}
