package week2.day2Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();// Click on Create New Account button		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Guna");//Enter the first name
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Venkatrao");//Enter the last name
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("9788193401");//Enter the mobile number
		driver.findElement(By.xpath("//input[@data-type='password']")).sendKeys("test@123");//Enterthe password
		
		//Day Dropdown
		WebElement dayd1 = driver.findElement(By.id("day"));
		Select d1=new Select(dayd1);
		d1.selectByVisibleText("3");
		
		//momth dropdown
		WebElement monthd2 = driver.findElement(By.id("month"));
		Select d2=new Select(monthd2);
		d2.selectByVisibleText("Mar");
		
		//year dropdown
		WebElement yeard3 = driver.findElement(By.id("year"));
		Select d3=new Select(yeard3);
		d3.selectByVisibleText("1992");
		
		//Select the radio button "Female" 
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		Thread.sleep(3000);
		
		driver.close();
	
		
	}
	
	

}
