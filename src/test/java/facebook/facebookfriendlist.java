package facebook;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;


public class facebookfriendlist {

    @Test
    public void faceBook() throws IOException, InterruptedException {

        String email = "";
        String pwd = "";
        int ExpectedFriendList = 363;

        String name;
        InputStream input = new FileInputStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);

        email = prop.getProperty("facebook_email");
        pwd = prop.getProperty("facebook_pwd");

        System.setProperty("webdriver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.get("https://www.facebook.com");

        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.name("pass")).sendKeys(pwd);
        wd.findElement(By.xpath("//*[@value='Log In']")).click();

        Thread.sleep(20000);
        wd.findElement(By.xpath("")).click();
        Thread.sleep(3000);
        wd.findElement(By.xpath("")).click();
        Thread.sleep(3000);

        //boolean loop = true;
        while (true) {

            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("window.scrollBy(0,1000)");

            try {
                WebElement more = wd.findElement(By.xpath(""));
                if (more.getText() != null) {
                    break;

                }
            } catch (NoSuchElementException e) {

            }

            List<WebElement> nameElements = wd.findElements(By.xpath(""));
            //To print friend list
            for (WebElement nameElement : nameElements) {
                System.out.println(nameElement.getText());
            }

            Assert.assertEquals(ExpectedFriendList, nameElements.size());
            wd.quit();

        }

    }
}
