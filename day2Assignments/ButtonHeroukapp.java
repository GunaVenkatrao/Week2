package week2.day2Assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonHeroukapp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		//Click button to travel home page
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		
		//Find position of button (x,y)
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("Position of button in (x,y) is  "+location);
		
		//Find button color
        String color = driver.findElement(By.id("color")).getCssValue("background-color");
        System.out.println("Button color is  "+color);
        
        //Find the height and width
        Dimension size = driver.findElement(By.id("size")).getSize();
        System.out.println("Size of the button is  "+size);
        
        driver.close();
        
	}

}
