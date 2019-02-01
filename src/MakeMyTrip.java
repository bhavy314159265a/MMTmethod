import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTrip {
	WebDriver driver = new ChromeDriver();
	private void launchBrowser() {
		driver.get("https://www.makemytrip.com/");

	}
	private void SearchTrip() {
		driver.findElement(By.cssSelector("#hp-widget__sTo")).sendKeys("goa");
		driver.findElement(By.xpath("//span[contains(text(),'Goa, India ')]")).click();
		driver.findElement(By.xpath("//input[@mt-id='returnDate']")).click();
		driver.findElement(By.xpath("//*[contains(@class,'dateFilterReturn ')]/div/div[1]/table/tbody/tr[4]/td[5]")).click();
		driver.findElement(By.xpath("//button[@id = 'searchBtn']")).click();

	}
	private void TripSelection() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='row wrap-dep']/div[2]/div/div/div[4]")).click();
		driver.findElement(By.xpath("//div[@class='row wrap-ret']/div[2]/div/div/div[5]")).click();
		driver.findElement(By.xpath("//span[@class='clearfix']/a")).click();
	}
	private void Login() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.switchTo().frame("notification-frame-~5586290a");
		driver.findElement(By.xpath("//*[@class='close']")).click();
		driver.switchTo().parentFrame();
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'continue_login')][1]/div[4]/a[@title='Login & Continue']")));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.click();
		driver.findElement(By.xpath("//form[@id = 'login_form_0']/p[1]/span/input")).sendKeys("khanna.micky@hotmail.com");
		driver.findElement(By.xpath("//form[@id = 'login_form_0']/p[2]/span/input[2]")).click();
		driver.findElement(By.xpath("//form[@id = 'login_form_0']/p[2]/span/input[1]")).sendKeys("Bhavya@1996");
		driver.findElement(By.xpath("//form[@id = 'login_form_0']/p[4]/input")).click();
		WebElement continuebtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"continueToReview\"]")));
		continuebtn.click();
	}
	private void addDetails() {
		driver.findElement(By.xpath("//div[@class='row']/div/div/div/div/div/p/span[2][contains(@class,'first_name')]/input")).sendKeys("Bhavya");
		driver.findElement(By.xpath("//div[@class='row']/div/div/div/div/div/p/span[3][contains(@class,'last_name')]/input")).sendKeys("Khanna");
		driver.findElement(By.xpath("//div[@class='row']/div/div/div/div/div/p/span[2][contains(@class,'gender_option')]/a[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'clearfix')]/p[contains(@class,'button')]/a")).click();
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhavyakhanna\\Downloads\\chromedriver_win32\\chromedriver.exe");
		MakeMyTrip obj = new MakeMyTrip();
		obj.launchBrowser();
		obj.SearchTrip();
		obj.TripSelection();
		obj.Login();
		obj.addDetails();
	}

}
