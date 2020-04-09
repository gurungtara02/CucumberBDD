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

public class _5NewLetterVerification {
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
    public void verifyNewsLetter() throws InterruptedException {
        String invalidEmail = "gurung.gmail.com";
        String validEmail = "gurung123@gmail.com";

        wd.findElement(By.cssSelector(".newsletter-input")).sendKeys(invalidEmail);
        wd.findElement(By.name("submitNewsletter")).click();

        //verify  error message
        Assert.assertEquals(wd.findElement(By.cssSelector(".alert.alert-danger")).getText(), "Newsletter : Invalid email address.");
        Thread.sleep(4000);

        //input Valid email and verify the result
        wd.findElement(By.cssSelector(".newsletter-input")).sendKeys(validEmail);
        wd.findElement(By.name("submitNewsletter")).click();

        //verify  error message
        boolean alreadyRegistered = false;
        if (alreadyRegistered == false) {
            Assert.assertEquals(wd.findElement(By.cssSelector(".alert.alert-sucess")).getText(), "Newsletter : You have successfully subscribed to this newsletter.");
        } else {
            Assert.assertEquals(wd.findElement(By.cssSelector(".alert.alert-danger")).getText(), "Newsletter : This email address is already registered.");

        }

    }

        @After
        public void end(){
            wd.quit();
        }
    }
