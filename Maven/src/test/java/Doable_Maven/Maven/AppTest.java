package Doable_Maven.Maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Samples
 */
public class AppTest {
	public static void main(String[] args) {

		WebDriver wd = null;

		try {

			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\drivers\\chromedriver.exe");
			wd = new ChromeDriver();
			wd.manage().window().maximize();
			wd.get("https://wordpress.com/");
			String url=wd.getCurrentUrl();
			System.out.println("URL : "+url);
			Thread.sleep(3000);
			wd.navigate().to("https://google.com");
			wd.navigate().back();
			Thread.sleep(3000);
			wd.navigate().forward();
			
			Thread.sleep(3000);
			
			String pageSource = wd.getPageSource();
			// System.out.println("Page source starts here >>>>>>>>>>>\n" +pageSource);
			// ieDriver.findElement(By.xpath("//div[@class='assign_gridassign_grid_selected']")).getAttribute("login");
			System.out.println("Intended text>>>>"+ wd.findElement(By.xpath("//ul[@class='wpcom-features-abv']")).getAttribute("id"));
			 

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			wd.quit();
		}

	}

}
