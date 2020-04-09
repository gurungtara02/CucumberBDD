package _8CucumberBDD.StepsDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver wd;

    @Given("^User is in gmail login page$")
    public void userIsInGmailLoginPage() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        wd=new ChromeDriver();
        wd.get("http://www.gmail.com");
        wd.manage().window().maximize();

    }

    @When("^Enters valid user in user Field$")
    public void entersValidUserInUserField() {
        WebElement txtemail = wd.findElement(By.id("identifierId"));
        txtemail.sendKeys("qatesting00567");
    }

    @And("^Click next button$")
    public void clickNextButton() throws InterruptedException{
        WebElement nextButtonElement = wd.findElement(By.xpath("//*[@id='identifierNext']"));
        nextButtonElement.click();
        Thread.sleep(5000);

    }

    @And("^enters valid password in password field$")
    public void entersValidPasswordInPasswordField() {
        WebElement txtpwd = wd.findElement(By.name("password"));
        txtpwd.sendKeys("Test@123");

    }

    @And("^Click on next button to login$")
    public void clickOnNextButtonToLogin() {
        WebElement btnNext = wd.findElement(By.id("passwordNext"));
        btnNext.click();
    }

    @Then("^User is on email profile page$")
    public void userIsOnEmailProfilePage() throws InterruptedException{
        Thread.sleep(5000);
        String expectedInbox="Inbox";
        WebElement elementInbox = wd.findElement(By.xpath("//a[text()='Inbox']"));
        Assert.assertEquals(expectedInbox,elementInbox.getText());


    }

    @And("^enters invalid password in password field$")
    public void entersInvalidPasswordInPasswordField() throws InterruptedException {
        //String gmailPassword=new GmailValidInvalid().getProperty
        WebElement txtpwd = wd.findElement(By.name("password"));
        txtpwd.sendKeys("Test@12");
    }

    @Then("^Verify the error message in login page$")
    public void verifyTheErrorMessageInLoginPage() throws InterruptedException {
        Thread.sleep(5000);
        String expectedInbox = "Wrong password. Try again or click Forgot password to reset it.";
        WebElement elementInbox = wd.findElement(By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']"));
        Assert.assertEquals(expectedInbox,elementInbox.getText());
    }
}
