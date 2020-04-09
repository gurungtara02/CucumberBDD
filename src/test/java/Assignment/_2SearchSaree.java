package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2SearchSaree {
    WebDriver wd;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver__.exe");
        //Create ChromeDriver instance
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @Test
    public void SearchSaree() throws InterruptedException {
        wd.findElement(By.id("")).sendKeys("Saree");
        wd.findElement(By.name("")).click();
        String SearchMsg = wd.findElement(By.className("")).getText();
        Assert.assertEquals(SearchMsg, "0 results have been found.");

        String AlertMsg = wd.findElement(By.cssSelector("")).getText();
        Assert.assertEquals(AlertMsg, "No result was found for your search\"Saree");
        Thread.sleep(3000);
    }

    @After
    public void end() {
        wd.quit();
    }
}
