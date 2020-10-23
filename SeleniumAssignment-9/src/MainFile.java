import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainFile 
{
	PropertyRead propertyRead;
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		propertyRead=new PropertyRead();
		System.setProperty("webdriver.chrome.driver", propertyRead.get_chromeDriverPath());
		driver = new ChromeDriver();
		driver.get(propertyRead.get_Url());
		driver.manage().window().maximize();
	}

	@Test
	public void test() {

		String topic=propertyRead.get_topic();
		driver.findElement(By.xpath("/html/body/div[4]/div/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"gsc-i-id1\"]")).sendKeys(topic);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
