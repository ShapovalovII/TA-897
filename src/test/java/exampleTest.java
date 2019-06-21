import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;

    private By birthday_day_CSSSELECTOR = By.cssSelector(ta("Facebook:Birthday:Initial_CssSelector", "#day"));
    private By birthday_day_TAGNAME = By.tagName(ta("Facebook:Birthday:Initial_TagName", "select"));


    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
    }

    @Test
    public void checkByCssSelectorTest() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        Select select = new Select(driver.findElement(birthday_day_CSSSELECTOR));
        select.selectByValue("3");
        Thread.sleep(5000);
    }

    @Test
    public void checkByTagNameTest() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        Select select = new Select(driver.findElement(birthday_day_TAGNAME));
        select.selectByValue("3");
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
