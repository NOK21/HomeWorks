import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by SamsungR538 on 18.04.2016.
 */
public class SkillsUpSearch extends BaseTest {
    private String HomePage = "http://skillsup.ua/";
    private By OurTeam = By.linkText("Наша команда");
    private By Coach1 = By.xpath("//div[@id='page_position_content']/div[3]/div/div[3]/a/span");
    private By Coach2 = By.xpath("//div[@id='page_position_content']/div[3]/div[3]/div/a/span[2]");
    private By Coach3 = By.xpath("xpath=(//img[@alt='photo'])[23]");
    private String ActualNameCoach1;
    private String ExpectedNameCoach1 = "Катерина Присяжнюк";
    private String ExpectedPositionCoach2 = "координатор учебного центра";
    private String ExpectedNameCoach3 = "Артем Карпов";


    @Test
    public void testSearchCoachPrysiazhniuk() throws Exception {
        webDriver.get(HomePage);
        webDriver.findElement(OurTeam).click();
        assertTrue(webDriver.findElement(Coach1).isDisplayed());
        ActualNameCoach1 = webDriver.findElement(Coach1).getText();
        assertEquals(ExpectedNameCoach1, ActualNameCoach1);
    }

    @Test
    public void testSearchCoachChokan() throws Exception {
        webDriver.get(HomePage);
        webDriver.findElement(OurTeam).click();
        assertTrue(webDriver.findElement(Coach2).isDisplayed());
        assertEquals(ExpectedPositionCoach2, webDriver.findElement(Coach2).getText());
    }

    @Test
    public void testSearchCoachKarpov() throws Exception {
        webDriver.get(HomePage);
        webDriver.findElement(OurTeam).click();
        try {
            assertTrue(webDriver.findElement(Coach3).isDisplayed());
            assertEquals("It's not Artem Karpov", ExpectedNameCoach3, webDriver.findElement(Coach3).getText());
        } catch (NoSuchElementException e) {
            System.out.println("It's time to update page with coaches");
        }
    }
}