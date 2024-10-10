package demoqatests;
import org.testng.annotations.Test;

public class BasicAuthDemo extends BaseTest{



        @Test
        public void testBasicAuth() throws InterruptedException {
            driver.get("https://admin:admin@practice.expandtesting.com/digest-auth");
            Thread.sleep(5000);
        }
    }

