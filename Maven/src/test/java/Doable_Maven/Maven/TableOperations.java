package Doable_Maven.Maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class TableOperations {
	
	public static WebDriver driver = null;
	
	@BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    //driver = new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    baseUrl = "http://stgfba.anchanto.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	
	

	public static String extractStringBetweenText(String strReplace, String Text1, String Text2) {
		String Value = null;
		int t1Length = 0;
		try {
			
			t1Length = Text1.length();
			Value = strReplace.substring(strReplace.indexOf(Text1)+t1Length, strReplace.indexOf(Text2));
			Value=Value.trim();
			
		} catch (Exception e) {
			System.out.println("ExtractStringBetweenText Exception: " + e);
		}
		return Value;

	}
	
	public static String getTableRowData(String tableLocator, int row){
		String values = "";
		String trTag = "/tbody/tr[?1]/td[?2]";
		trTag = trTag.replace("?1",String.valueOf(row));
		String temp = "";
		int col = 1;
		int colCount = getTableColumnCount(tableLocator);

		for(; col<=colCount; col++){
			temp = trTag.replace("?2",String.valueOf(col));
			values = values+";"+getText(tableLocator+temp);	
		}

		return values;
	}
	public static String getText(String locator)
	{
		WebElement element;
		String text = "NO VALUE RETRIEVED";
		try{
			element = findElement(locator,true);		
			if(element != null)
				//text = ((JavascriptExecutor)WrapperActions.driver).executeScript("return arguments[0].innerHTML", element).toString();
				text = element.getText();
			//System.out.println(" Elemet text :::"+text);
			//text = element.getAttribute("value");
		}catch(Exception e){
			//logMessage("Get text of element.","Exception occured. Exception : "+e.getMessage(), "fail");
		}
		element = null;
		
		return text;
	}
	public static WebElement findElement(String locator,boolean val){
		if (locator != null){
			String[] arrLocator = locator.split("==");
			String locatorTag = arrLocator[0].trim();
			String objectLocator = arrLocator[1].trim();
			try{
				if (locatorTag.equalsIgnoreCase("id")){
					webelement = driver.findElement(By.id(objectLocator));
				}
				else if (locatorTag.equalsIgnoreCase("name")){
					webelement = driver.findElement(By.name(objectLocator));
				}
				else if (locatorTag.equalsIgnoreCase("xpath")){
					webelement = driver.findElement(By.xpath(objectLocator));
				}
				else if (locatorTag.equalsIgnoreCase("linkText")){
					webelement = driver.findElement(By.linkText(objectLocator));
				}
				else if (locatorTag.equalsIgnoreCase("class")){
					webelement = driver.findElement(By.className(objectLocator));
				}
				else if (locatorTag.equalsIgnoreCase("css")){
					webelement = driver.findElement(By.cssSelector(objectLocator));
				}
			} catch (Exception exception){
				System.out.println(" Exception in Find Element @ WrapperActions :"+ exception.getMessage());
				return null;
			}
		}
		return webelement;	
	}
	
	
	
	
	public static int getTableColumnCount(String tableLocator){
		int colCount = 0;
		String trTag = "/thead/tr[1]/th[?]";
		String temp = trTag;
		WebElement row;

		driver.manage().timeouts().implicitlyWait(01, TimeUnit.SECONDS);
		if(findElement(tableLocator,true) == null)
			return colCount;

		do{
			temp = trTag;
			colCount++;
			row = findElement(tableLocator+temp.replace("?",String.valueOf(colCount)),true);
		}while(row != null);

		colCount--;
		driver.manage().timeouts().implicitlyWait(defaultBrowserTimeOut, TimeUnit.SECONDS);
		return colCount;
	}


	public static void main(String args[]) {
		
		TableOperations Ex = new TableOperations();
		String S1 = "Showing 1 to 5 of 5 entries";
		String S2 = TableOperations.extractStringBetweenText(S1,"of","entries" );
		System.out.println("After Concat main()        :" + S2);

	}
}
