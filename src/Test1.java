import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new java.util.Date());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
		Actions a = new Actions(driver);
		driver.get("https://intershoppwa.azurewebsites.net/home");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.=' Accept All ']"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[.='Sign In'])[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bboldner@test.intershop.de");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("!InterShop00!");
		driver.findElement(By.name("login")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='ng-star-inserted']")));
		String userFirstName = driver.findElement(By.xpath("//h1[@class='ng-star-inserted']")).getText();
		if (userFirstName.contains("BERNHARD")) {
			System.out.println("User Logged In");
		} else {
			System.out.println("User was not logged In");
		}
		WebElement computers = driver.findElement(By.xpath("//a[@href='/computers-ctgComputers']"));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/computers-ctgComputers']")));
//		System.out.println("test2");
		a.moveToElement(computers).build().perform();
		WebElement Acer = driver.findElement(By.xpath("//a [.='Acer']"));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [.='Acer']")));
		a.moveToElement(Acer).click().build().perform();
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//img [@alt='Acer ICONIA W501P product photo']"))).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		driver.findElement(By.xpath("//div[@class='quick-cart-link d-md-block']")).click();
		driver.findElement(By.xpath("//a[.=' View Cart ']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("formly_1_ish-select-field_costCenter_0")))
				.isDisplayed();
		WebElement costCenterDD = driver.findElement(By.id("formly_1_ish-select-field_costCenter_0"));
		Select CC = new Select(costCenterDD);
		CC.selectByValue("100400");
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.=' Checkout ']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']"))).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//dd[@class='col-6 total-price']")));
		String receiptUrl = driver.getCurrentUrl();
		if (receiptUrl.contains("https://intershoppwa.azurewebsites.net/checkout/re")) {
			System.out.println("\n" + "Order was placed Sucessfully");
			String orderID = driver.findElement(By.xpath("//strong/a")).getText();
			String orderTotal = driver.findElement(By.xpath("//dd[@class='col-6 total-price']")).getText();
			String pageTitle = driver.getTitle().replace("|", "");
			System.out
					.println("\n" + "Your Order ID is " + orderID + "\n" + "\n" + "Your Order Total is " + orderTotal);
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File("D:\\TestSS\\" + pageTitle + timeStamp + ".png"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Screenshot not taken");
			}

		} else {
			System.out.println("\n" + "Order was Failed");

		}
		driver.quit();
	}

}
