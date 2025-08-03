package intronics.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntronicsRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://intershoppwa.azurewebsites.net/home");
		WebElement privacyAlert = driver.findElement(By.xpath("//button[.=' Accept All ']"));
		if(privacyAlert.isDisplayed()) {
			privacyAlert.click();
		}
	}

}
