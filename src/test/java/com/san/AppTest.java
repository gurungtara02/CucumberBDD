package com.san;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest 
{
    @Test
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver wd = new ChromeDriver();

        wd.manage().window().maximize();
        wd.get("http://www.gmail.com");

        //WebElement elementEmail = wd.findElement(By.xpath("//*[@id='identifierId']"));
        //WebElement elementEmail = wd.findElement(By.name("identifier"));
        WebElement elementEmail = wd.findElement(By.id("identifierId"));
        elementEmail.sendKeys("gurungtara02@gmail.com");

        WebElement elementNext = wd.findElement(By.xpath("//*[@id=\'identifierNext\']/span/span"));
        elementNext.click();

        Thread.sleep(3000);

        WebElement elementPassword = wd.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input"));
        elementPassword.sendKeys("jjgj");


        Thread.sleep(3000);
        wd.quit();
        //assertTrue( true );
    }
}
