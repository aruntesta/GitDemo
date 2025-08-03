import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import java.lang.Object;

import org.testng.Assert;

public class Test4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String userName = driver.findElement(By.xpath("(//b/i)[1]")).getText();
		String password = driver.findElement(By.xpath("(//b/i)[2]")).getText();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[.=' User']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okayBtn")))).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dd = new Select(dropdown);
		dd.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button [@class='btn btn-info']")));
		List<WebElement> addToCart = driver.findElements(By.xpath("//button [@class='btn btn-info']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(addToCart));
		for (int i = 0; i <= addToCart.size() - 1; i++) {
			addToCart.get(i).click();
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	}
}
