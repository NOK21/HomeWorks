import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by SamsungR538 on 11.04.2016.
 */
public class FirstTest extends BaseTest {
    private By input = By.id("searchInput");
    private By image = By.xpath("//img[@alt='Logo Tesla Motors.svg']");
    private By discription = By.xpath("//div[@id='mw-content-text']/table/tbody/tr[2]/td/p");
    //protected java.lang.String url = "https://ru.wikipedia.org";

    @Test
    public void testSearchTesla() throws Exception {
        WebElement wikiSearch = webDriver.findElement(input);
        wikiSearch.sendKeys("Tesla Motors");
        wikiSearch.submit();
        assertTrue(webDriver.getTitle().contains("Tesla"));
        WebElement proof = webDriver.findElement(image);
        assertTrue(proof.isDisplayed());
    }

    @Test
    public void testSearchSelenium() throws Exception {
        WebElement wikiSearch = webDriver.findElement(input);
        wikiSearch.sendKeys("Selenium");
        wikiSearch.submit();
        WebElement discript = webDriver.findElement(discription);
        assertEquals("Wrong page", "тестирование программного обеспечения", discript.getText());
    }

}







