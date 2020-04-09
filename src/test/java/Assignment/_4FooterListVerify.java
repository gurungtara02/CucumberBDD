package Assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _4FooterListVerify {
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
    public void verifyFootersList() throws InterruptedException {
        List<String> footers= new ArrayList<String>(Arrays.asList("My orders","My credit slips","My addresses","My personal info"));
        List<String> actualArray=new ArrayList<>();
        //IReadOnlyCollection<IWebElement>  footers= wd.FindElements(By.CssSelector(".bullet>li"));  OR below lin
        var eFooters = wd.findElements(By.cssSelector(".bullet>li"));
        for(var footer : eFooters)
        {//Console.WriteLine(footer.Text);
            actualArray.add(footer.getText());
        }
        Assert.assertEquals(footers, actualArray);
    }
    @After
    public void end(){
        wd.quit();
    }
}
