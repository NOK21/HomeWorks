import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by SamsungR538 on 12.04.2016.
 */
public class BaseTest extends TestCase {
    protected static FirefoxDriver webDriver;

    @BeforeClass
    public void setUp() throws Exception {
        webDriver = new FirefoxDriver();
        webDriver.get("https://ru.wikipedia.org");
    }

    @AfterClass
    public void tearDown() throws Exception {
        webDriver.quit();
    }
}