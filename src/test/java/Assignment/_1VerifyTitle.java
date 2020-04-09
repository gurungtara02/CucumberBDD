package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1VerifyTitle {

    WebDriver wd;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "chromedriver__.exe");
        //Create ChromeDriver instance
        wd = new ChromeDriver();
        wd.get("http://automationpractice.com/index.php");
        wd.manage().window().maximize();
    }

    @Test
    public void verifyTitle() {
        //int a=0101; // output ke huncha.. if you print a..
        //System.out.println(a);
        String expectedTitle="My Store";
        Assert.assertEquals(expectedTitle,wd.getTitle());
    }
    @After
    public void end(){
        wd.quit();
    }

}
