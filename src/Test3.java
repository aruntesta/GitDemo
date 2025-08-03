import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		String userName = driver.findElement(By.id("login_credentials")).getText();
		System.out.println(userName);
		String Password = driver.findElement(By.xpath("//div[@class='login_password']")).getText();
		System.out.println("\n" + Password);
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement sortProduct = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sort = new Select(sortProduct);
		sort.selectByValue("hilo");
		driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
		driver.findElement(By.xpath("//button[.='Add to cart']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Arun");
		driver.findElement(By.id("last-name")).sendKeys("Raj");
		driver.findElement(By.id("postal-code")).sendKeys("10001");
		driver.findElement(By.id("continue")).click();

		System.out.println(
				"\n" + driver.findElement(By.xpath("//div[@class='summary_value_label'][1]")).getText() + "\n");
		System.out.println(driver.findElement(By.xpath("//div[@class='summary_value_label'][2]")).getText() + "\n");
		System.out.println(
				driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']")).getText());
		driver.findElement(By.id("finish")).click();
		System.out.println("\n" + driver.findElement(By.xpath("//span")).getText());
		driver.findElement(By.id("back-to-products")).click();
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("\n" + "User is Logged out");
		driver.quit();
	}

}
