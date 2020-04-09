package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6ScrollBarVerification {

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
    public void verifyScrollBar() throws InterruptedException {
        int target =53;
        wd.findElement(By.xpath("//a[@title='Women']")).click();

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,1500)");

        WebElement slider = wd.findElement(By.cssSelector(".ui-slider-range.ui-widget-header.ui-corner-all"));
        Actions move = new Actions(wd);
        Thread.sleep(3000);

        for (int i=1; i <= target; i=i+10) {
            Action action = (Action) move.dragAndDropBy(slider, i, 0).build();
            action.perform();
        }
        Thread.sleep(3000);
        Assert.assertEquals(wd.findElement(By.id("layered_price_range")).getText(),"$53.00 - $53.00");
        }
//        WebElement women = wd.findElement(By.linkText("Women"));
//        women.click();
//        Thread.sleep(3000);
//        WebElement slider = wd.findElement(By.xpath(""));
//        Actions action = new Actions(wd);
    @After
    public void end() {
        wd.quit();
    }
}
