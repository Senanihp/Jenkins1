package maven_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo_web_shop_searchTest {
@Test
public void Tc_Search() {
	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	 driver.get("https://demowebshop.tricentis.com/");
	 driver.manage().window().maximize();
	 driver.findElement(By.cssSelector("input[id=\"small-searchterms\"]")).sendKeys("books");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 driver.close();
}
}
