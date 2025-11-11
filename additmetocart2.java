package first.first1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class additmetocart2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Items to add
        String[] itemsNeeded = { "Cucumber", "Beetroot", "Cauliflower" };
        List<String> itemsList = Arrays.asList(itemsNeeded);

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int addedCount = 0;

        for (int i = 0; i < products.size(); i++) {
            // Product text comes like "Cucumber - 1 Kg", so split
            String productName = products.get(i).getText().split("-")[0].trim();

            if (itemsList.contains(productName)) {
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                addedCount++;

                if (addedCount == itemsNeeded.length) {
                    break;
                }
            }
        }

        // Click Cart
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));

        // Place order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        // Select country from dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
        Select country = new Select(driver.findElement(By.cssSelector("select")));
        country.selectByVisibleText("India");

        // Check checkbox
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();

        // Proceed
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();

        driver.quit();
    }
}
