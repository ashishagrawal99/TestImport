package Doable_Maven.Maven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoSelect{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String textToSelect = "healthkart";
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try{



			//WebDriver driver = new FirefoxDriver();
			driver.get("https://www.google.co.in/");
			Thread.sleep(2000);
			WebElement autoOptions= driver.findElement(By.id("lst-ib"));
			autoOptions.sendKeys("he");
			System.out.println("textToSelect:"+textToSelect);

			List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@id='sbse1']/div[2]/b"));

			for(WebElement option : optionsToSelect){	
				System.out.println(option);
				if(option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: "+textToSelect);
					option.click();
					break;
				}
				System.out.println("Selected:"+textToSelect);
				Thread.sleep(3000);
			}
		}catch(Exception e){

			System.out.println("Exception:" +e);
		}
		finally{
			driver.quit();
		}
	}
}
