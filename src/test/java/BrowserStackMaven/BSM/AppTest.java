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
	    System.out.println("still running");
	  }
}

