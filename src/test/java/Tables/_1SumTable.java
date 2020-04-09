package Tables;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class _1SumTable {

    public WebDriver wd;
    public ChromeOptions options;
    int expectedSum = 750;

    @Before
    public void setBrowser()
    {
        //JUNIT, @Before, @Test and @After
        System.setProperty("webdriver.chrome.driver", "chromedriver_old.exe");
        wd = new ChromeDriver();
        wd.get("https://www.computerhope.com/jargon/h/html-tr-tag.htm");
        wd.manage().window().maximize();
    }

    @Test
    public void sumSavings()
    {
     List<WebElement> rows = wd.findElements(By.xpath("//*[@id=\'main-content\']/article/table[1]/tbody/tr/td[2]"));
     int totalCost = 0;
     for(WebElement wb:rows)
        {
            //remove dollar sign from $250 as 250.
            String price = wb.getText().substring(1); // start from 1 so remove 1 start char eg $200 gives 200
            int cost = Integer.parseInt(price); //Convert string to int
            totalCost = totalCost + cost;
        }
     Assert.assertEquals(expectedSum,totalCost);

    }
    @After
    public void Quit()
    {
        wd.quit();
    }

}
