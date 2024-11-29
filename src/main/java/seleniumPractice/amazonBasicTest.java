package seleniumPractice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class amazonBasicTest {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		String Expected_Title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		String Actual_Title=driver.getTitle();
		
		System.out.println(Actual_Title);
		
		if(Expected_Title.equals(Actual_Title)) {
			System.out.println("Site is open properly");
		}
		else {
			System.out.println("Site not opened");
		}
		
		WebElement check_logo=driver.findElement(By.xpath("//a[@aria-label=\"Amazon.in\"]"));
		
		if(check_logo.isDisplayed()) {
			System.out.println("amazon logo is displayed");
		}
		else {
			System.out.println("amazon logo is not displayed");
		}
		
		WebElement enterproduct=driver.findElement(By.id("twotabsearchtextbox"));
		enterproduct.sendKeys("Bluetooth headset");
		
		WebElement searchproduct=driver.findElement(By.cssSelector("input[value=\"Go\"]"));
		searchproduct.click();
		
		WebElement selectboat=driver.findElement(By.xpath("//span[text()='boAt']"));
		selectboat.click();
		
		List<WebElement> products=driver.findElements(By.xpath("//div[@class=\"sg-col-4-of-24 sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 sg-col s-widget-spacing-small sg-col-4-of-20\"]"));
		System.out.println(products.size());
		
		for(WebElement datas: products) {
			String Nameoftheproduct=datas.findElement(By.xpath(".//div[@data-cy='title-recipe']")).getText();
			String Priceoftheproduct=datas.findElement(By.xpath(".//div[@class='a-section a-spacing-none a-spacing-top-small s-price-instructions-style']//span[@class='a-price-whole']")).getText();
			String Price=Priceoftheproduct.replace(",", "");
			int PriceValue=Integer.parseInt(Price);
			if(PriceValue >=1000) {
				System.out.println("Name of the Product :"+Nameoftheproduct);
				System.out.println("Price of the Product :"+Price);
				System.out.println("======================================================================");
				
			}
		}
		
		
	}

}
