package first.first1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class maventest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("First Maven Project");
		WebDriverManager.chromedriver().setup() ;
		
		WebDriver Driver = new ChromeDriver()  ;
		
		Driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println(Driver.getTitle());
		Driver.manage().window().maximize();
		Thread.sleep(5000);
		//Driver.manage().wait(5);
		Driver.findElement(By.id("username")).sendKeys("student");
		Driver.findElement(By.id("password")).sendKeys("Password123");
		Driver.findElement(By.id("submit")).click();
		
		
		

	}

}
