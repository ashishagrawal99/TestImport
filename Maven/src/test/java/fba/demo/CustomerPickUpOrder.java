/**Order Customer Pickup ERROR: Line 170
 * 
 */
package fba.demo;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerPickUpOrder {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    baseUrl = "http://stgfba.anchanto.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testOrderCustomerPickup() throws Exception {
    driver.get(baseUrl);
 /*   driver.findElement(By.id("sign-in-nav")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("anc.bhat@gmail.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("welcome@123");
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[4]/a/span")).click();
    driver.findElement(By.cssSelector("li.open > ul.submenu > li > a > span.menu-text")).click();
    driver.findElement(By.id("shipping_address_firstname")).clear();
    driver.findElement(By.id("shipping_address_firstname")).sendKeys("Saket");
    driver.findElement(By.name("blk_bld_no")).clear();
    driver.findElement(By.name("blk_bld_no")).sendKeys("Singapore");
    driver.findElement(By.name("shipping_address[zipcode]")).clear();
    driver.findElement(By.name("shipping_address[zipcode]")).sendKeys("8608670");
    driver.findElement(By.id("shipping_address_contact1")).clear();
    driver.findElement(By.id("shipping_address_contact1")).sendKeys("9798689769");
    driver.findElement(By.name("shipping_address[zipcode]")).clear();
    driver.findElement(By.name("shipping_address[zipcode]")).sendKeys("860867");
    
    Thread.sleep(3000);
    driver.findElement(By.id("order_bucket_order_number")).clear();
    driver.findElement(By.id("order_bucket_order_number")).sendKeys("OrdTest9901"); //change
    driver.findElement(By.id("order_bucket_express_delivery")).click();
    driver.findElement(By.id("order_bucket_is_customer_pickup")).click();
    driver.findElement(By.id("order_bucket_delivery_date")).click();
    driver.findElement(By.linkText("31")).click();
    
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("order_bucket_delivery_slot_id"))).selectByVisibleText("1PM - 3PM");
    new Select(driver.findElement(By.id("order_bucket_pickup_location_id"))).selectByVisibleText("TestingStore");
    
    Thread.sleep(3000);
    driver.findElement(By.id("product_name")).clear();
    driver.findElement(By.id("product_name")).sendKeys("Green Glass");
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_DOWN);
    r.keyRelease(KeyEvent.VK_DOWN);
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    driver.findElement(By.id("qty_21041")).clear();
    driver.findElement(By.id("qty_21041")).sendKeys("1");
    
    Thread.sleep(3000);
    driver.findElement(By.id("add_btn")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    
    Thread.sleep(3000);
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to submit[\\s\\S]$"));
    
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("div.search-wrapper > input[type=\"text\"]")).clear();
    driver.findElement(By.cssSelector("div.search-wrapper > input[type=\"text\"]")).sendKeys("OrdTest_1");
    driver.findElement(By.linkText("OrdTest_1")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    driver.findElement(By.xpath("//table[@id='orders-list']/tbody/tr/td[3]/a/label")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Welcome, anc.bhat@gmail.com")).click();
    driver.findElement(By.linkText("Logout")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.id("sign-in-nav")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("ashish.agrawal@anchanto.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("Welcome@123");
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[9]/a/span")).click();
    driver.findElement(By.cssSelector("a[title=\"Ready For Pick Up\"] > span.menu-text")).click();
    
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("Retailer"))).selectByVisibleText("Automation&Testing Ltd.");
    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).clear();
    
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).sendKeys("OrdTest_1");
    driver.findElement(By.linkText("OrdTest_1")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
//    driver.findElement(By.xpath("//tr[@id='tr_1']/td[4]/a/label")).click();
//    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
//    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Assign")).click();
    
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("order_pickup_list_user_id"))).selectByVisibleText("Ranjana Bhat");
    driver.findElement(By.id("datepicker")).click();
    driver.findElement(By.linkText("26")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.id("assign_submit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Welcome, ashish.agrawal@anchanto.com")).click();
    driver.findElement(By.linkText("Logout")).click();
    
    Thread.sleep(3000);
 */   driver.findElement(By.id("sign-in-nav")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("ranjana.bhat@anchanto.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("ranjana@123");
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("a.dropdown-toggle > span.menu-text")).click();
    driver.findElement(By.cssSelector("a.dropdown-toggle > span.menu-text")).click();
    driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("a[title=\"Ready For Pick Up\"] > span.menu-text")).click();
    
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("Retailer"))).selectByVisibleText("Automation&Testing Ltd.");
    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).clear();
    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).sendKeys("OrdTest_1");
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("OrdTest_1")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
//    driver.findElement(By.xpath("//tr[@id='tr_<a href=\"/order_pickup_lists/7793\" class=\"fancybox fancybox.ajax\">OrdTest_1</a>']/td[3]/a/label")).click();
//    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
//    
    Thread.sleep(3000);
    //driver.findElement(By.cssSelector("h4.blue.bigger")).click();
    driver.findElement(By.linkText("Pick")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.id("item_8817")).clear();
    driver.findElement(By.id("item_8817")).sendKeys("1"); //ERROR: item_8817 not found
    
    Thread.sleep(3000);
    driver.findElement(By.id("order_pickup_list_bin_id_")).click();
    driver.findElement(By.cssSelector("div.action > input[name=\"commit\"]")).click();
    
    Thread.sleep(3000);
    //driver.findElement(By.linkText("Welcome, ranjana.bhat@anchanto.com")).click();
    //driver.findElement(By.linkText("Logout")).click();
    
   /* Thread.sleep(3000);
    driver.findElement(By.id("sign-in-nav")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("renuka.joshia@gmail.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("welcome@123");
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("a.dropdown-toggle > span.menu-text")).click();
    driver.findElement(By.cssSelector("ul.submenu > li > a > span.menu-text")).click();
    driver.findElement(By.cssSelector("ul.submenu > li > a > span.menu-text")).click();
    
    Thread.sleep(3000);
    new Select(driver.findElement(By.id("Retailer"))).selectByVisibleText("Automation&Testing Ltd.");
    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).clear();
    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).sendKeys("OrdTest_1");
    driver.findElement(By.linkText("OrdTest_1")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();*/
    
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//tr[@id='tr_<a href=\"/order_packing_lists/747\" class=\"fancybox fancybox.ajax\">OrdTest_1 </a>  ']/td[3]/a/label")).click();
//    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    
   /* Thread.sleep(3000);
    //driver.findElement(By.cssSelector("h4.blue.bigger")).click();
    driver.findElement(By.cssSelector("a.btn.btn-default")).click();
    driver.findElement(By.id("tracking_number")).clear();
    driver.findElement(By.id("tracking_number")).sendKeys("ANCBN14");
    
    Thread.sleep(3000);
    driver.findElement(By.id("bin_details")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    //driver.findElement(By.cssSelector("div.modal-header")).click();
    Thread.sleep(3000);
    driver.findElement(By.id("scan_btn")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.id("skus")).clear();
    driver.findElement(By.id("skus")).sendKeys("crl_02");
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Welcome, renuka.joshia@gmail.com")).click();
    driver.findElement(By.linkText("Logout")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.id("sign-in-nav")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("ashish.agrawal@anchanto..com");
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys("ashish.agrawal@anchanto.com");
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys("Welcome@123");
    driver.findElement(By.name("commit")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[11]/a/b")).click();
    driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[11]/ul/li[3]/a/span")).click();
    driver.findElement(By.cssSelector("div.search-wrapper > input[type=\"text\"]")).clear();
    driver.findElement(By.cssSelector("div.search-wrapper > input[type=\"text\"]")).sendKeys("OrdTest_1");
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("OrdTest_1")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
//    driver.findElement(By.linkText("ANC3A&T7851")).click();
//    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Pick")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.id("delivered_to")).clear();
    driver.findElement(By.id("delivered_to")).sendKeys("Saket");
    
    Thread.sleep(3000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.cssSelector("span.menu-text > span.menu-text")).click();
    
    Thread.sleep(3000);
    new Select(driver.findElement(By.name("Company"))).selectByVisibleText("Automation&Testing Ltd.");
    driver.findElement(By.cssSelector("div.search-wrapper > input[type=\"text\"]")).clear();
    driver.findElement(By.cssSelector("div.search-wrapper > input[type=\"text\"]")).sendKeys("OrdTest_1");
    driver.findElement(By.linkText("OrdTest_1")).click();
    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    
//    Thread.sleep(3000);
//    driver.findElement(By.xpath("//table[@id='pack-list']/tbody/tr/td[3]/a/label")).click();
//    driver.findElement(By.cssSelector("a.fancybox-item.fancybox-close")).click();
    
    Thread.sleep(3000);
    driver.findElement(By.linkText("Welcome, ashish.agrawal@anchanto.com")).click();
    driver.findElement(By.linkText("Logout")).click();*/
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}