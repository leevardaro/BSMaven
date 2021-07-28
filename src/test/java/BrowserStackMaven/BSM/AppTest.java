package BrowserStackMaven.BSM;
import org.testng.annotations.*;


public class AppTest {

  //public static final String username = "leevardaro_sqiF2Y";
  //public static final String accessKey = "XNR17aPXPp6NaNZNvyD2";
  public String username = System.getenv("BROWSERSTACK_username");
  public String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
  public static String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
  public static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
  public static String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
  public String URL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
  public static final String baseUrl = "https://jobs.workable.com/";
  //variables for assertions
  public static final String expectedTitle = "Job Search - Job Finder - Job Listings | Workable for Job Seekers";
  public static final String expJob = "Customer Engineer- San Francisco";
  
  @Test
  public void Testing() throws Exception {
	System.out.println("test started");
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
  }}