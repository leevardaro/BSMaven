package BrowserStackMaven.BSM;

import static org.testng.AssertJUnit.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{

	  //public static final String username = "leevardaro_sqiF2Y";
	  //public static final String accessKey = "XNR17aPXPp6NaNZNvyD2";
	  public String username = System.getenv("BROWSERSTACK_username");
	  public String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	  public static String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	  public String URL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
	  public static final String baseUrl = "https://jobs.workable.com/";
	  //variables for assertions
	  public static final String expectedTitle = "Job Search - Job Finder - Job Listings | Workable for Job Seekers";
	  public static final String expJob = "Customer Engineer- San Francisco";
	  @Test
	  public static void main(String[] args) throws Exception {
		Thread object1 = new Thread(new IPhone());
	    object1.start();
	    Thread object2 = new Thread(new Chrome());
	    object2.start();
	    Thread object3 = new Thread(new Safari());
	    object3.start();
	    Thread object4 = new Thread(new FireFox());
	    object4.start();
	    Thread object5 = new Thread(new Edge());
	    object5.start();
	  }
		public void executeTest(Hashtable<String, String> capsHashtable) {
			String key;
		  DesiredCapabilities caps = new DesiredCapabilities();
			// Iterate over the hashtable and set the capabilities
			Set<String> keys = capsHashtable.keySet();
	    Iterator<String> itr = keys.iterator();
	    while (itr.hasNext()) {
	       key = itr.next();
	       caps.setCapability(key, capsHashtable.get(key));
	    }
	    WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	    JavascriptExecutor jse = (JavascriptExecutor)driver;

			try {

	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        // launch browsers on job search site
	        driver.get(baseUrl);
	        String actualTitle = driver.getTitle();
	        
	        //assertion 1 
	        Assert.assertEquals(expectedTitle, actualTitle);
	    
	        //input job
	        WebElement jobSearch = driver.findElement(By.xpath("//*[@data-ui=\'search-input\']"));
	        jobSearch.sendKeys("browserstack customer experience engineer");
	        //input location and submit
	        WebElement locSearch = driver.findElement(By.xpath("//*[@data-ui=\'location-input\']"));
	        locSearch.sendKeys("San Francisco");
	        locSearch.submit();
	        // get rid of cookie bar
	        WebElement declineLink = driver.findElement(By.xpath("//*[@id='hs-eu-decline-button']"));
	        declineLink.click();
	        //click on job
	        WebElement jobLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[.='Customer Engineer- San Francisco']/..//a[@data-ui='job-view']")));
	        Boolean isPresent = driver.findElements(By.xpath("//h3[.='Customer Engineer- San Francisco']")).size() > 0;

	        //assertion 2
	        Assert.assertTrue(isPresent);
	        
	        jobLink.click();
	        //verify job
	        WebElement jobTitle = driver.findElement(By.xpath("//a[@href='http://www.browserstack.com']/../h1[@data-ui=\"preview-job-title\"]"));
	        String actualJob = jobTitle.getText();
	        
	        //assertion 3 passes test	    
		    Assert.assertEquals(actualJob, expJob);
		    

		    jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Correct Job!\"}}");
		    
		    //close driver
		    driver.quit();
			}
			catch (Exception e) {
				e.printStackTrace();
				jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Test Failed!\"}}");
			    
			    //close driver
			    driver.quit();	
			}
			}
}
