package first.first1;

import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.bcel.internal.generic.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.jvm.hotspot.runtime.Threads;

public class greenkartpractive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   WebDriverManager.chromedriver().setup();
	   WebDriver Driver = new ChromeDriver() ;
	   Driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	   Driver.manage().window().maximize();
	   Driver.getTitle();
	   
	   String[] itemsNeeded = { "Cucumber", "Beetroot", "Cauliflower" };
	   List<String> itemsNeededList = Arrays.asList(itemsNeeded);
	   
	   int itemCount = 0 ;
	   List <WebElement> products = Driver.findElements(By.className("product-name")); 
	   System.out.println("Total products found: " + products.size());
	   for (int i = 0 ; i <= products.size();i++)
	   {
		   // String productName = products.get(i).getText().trim();
		   String productName = products.get(i).getText().split("-")[0].trim();
			System.out.println(productName);
			if (itemsNeededList.contains(productName)) {
				System.out.println("Adding to cart: " + productName);
				//products.get(i).findElement(By.xpath("parent::div/following-sibling::div/button")).click();
				products.get(i)
	            .findElement(By.xpath("ancestor::div[@class='product']/div[@class='product-action']/button"))
	            .click();

				// Click Add to Cart button (same index)
				//Driver.findElements(By.xpath("//div[2]//div[3]//button[1]")).get(i).click();
				itemCount++;

				// Stop once all required items are added
				if (itemCount == itemsNeeded.length) {
					break;
				}
					
				
			}
	   }
	   Driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	   //Driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
	   //Driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
	   Driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	   WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));

	   Driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	   
	   
	   // Select country from dropdown
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
       Select country = new Select(Driver.findElement(By.cssSelector("select")));
       country.selectByVisibleText("India");
	   
	   Driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	   Driver.findElement(By.xpath("//button[text()='Proceed']"));
	   
	   Driver.close();
	   
	  
	
		
	}
}


