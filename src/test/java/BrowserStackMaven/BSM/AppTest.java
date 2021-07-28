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
@Test
public class AppTest 
{

	  //public static final String username = "leevardaro_sqiF2Y";
	  //public static final String accessKey = "XNR17aPXPp6NaNZNvyD2";
	  public String username = System.getenv("BROWSERSTACK_username");
	  public String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
	  public String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
	  public String URL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
	  public String baseUrl = "https://jobs.workable.com/";
	  //variables for assertions
	  public String expectedTitle = "Job Search - Job Finder - Job Listings | Workable for Job Seekers";
	  public String expJob = "Customer Engineer- San Francisco";
	  
	  @Test
	  public void test() throws Exception {
		  
		System.out.println("running test");
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
}

