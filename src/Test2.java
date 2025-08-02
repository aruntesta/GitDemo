import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import java.lang.Object;

import org.testng.Assert;


public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input#checkBoxOption3")).click();
		String selectedCheckbox = driver.findElement(By.xpath("//fieldset/label[@for='honda']")).getText();
		WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByVisibleText(selectedCheckbox);
		driver.findElement(By.xpath("//div/fieldset/input[@id='name']")).sendKeys(selectedCheckbox);
		driver.findElement(By.id("alertbtn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		
	}

}
