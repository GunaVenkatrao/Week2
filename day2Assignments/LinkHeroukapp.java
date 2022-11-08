package week2.day2Assignments;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LinkHeroukapp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		//Go to Home page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		
		//Find where am supposed to go without clicking me?
		String attribute1 = driver.findElement(By.xpath("(//div[@class='row'])[2]/div/a")).getAttribute("href");
		System.out.println("The link is "+attribute1);
		
		//verify am I Broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		Thread.sleep(3000);
		String linktitle = driver.getTitle();
		System.out.println(linktitle);
		if(linktitle.contains("404"))
		{
			System.out.println("The link is broken");
		}
		else
		{
			System.out.println("Link is valid");
		}
		driver.navigate().back();
		Thread.sleep(2000);
		
		//Go to Home page(Interact with same link name)
		List<WebElement> dup1 = driver.findElements(By.xpath("//a[text()='Go to Home Page']"));
		int dupsize1 = dup1.size();
		if(dupsize1>1)
		{
			System.out.println("Go to Home page is duplicated.And it is duplicated "+dupsize1+ " times");
		}
		else
		{
			System.out.println("Go to Home page is not duplicated");
		}
		
		//How many links are available in this page
		List<WebElement> count = driver.findElements(By.tagName("a"));
		int countlink=count.size();
		System.out.println("The total links are available in this page are " +countlink);
		driver.close();

	}

}
