package main.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.auth;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseurl = "https://saucedemo.com/";
    @Given("User access the website")
    public void userAccessTheWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

    }

    @When("User insert Username with the list provided")
    public void userInsertUsernameWithTheListProvided() {
        driver.findElement(By.id("user-name")).sendKeys(auth.username);
    }

    @And("User insert password with the list provided")
    public void userInsertPasswordWithTheListProvided() {
        driver.findElement(By.id("password")).sendKeys(auth.password);
    }

    @Then("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User on Dashboard Page")
    public void userOnDashboardPage() {
        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());
        driver.quit();
    }

    @And("User insert invalid password with the list provided")
    public void userInsertInvalidPasswordWithTheListProvided() {
        driver.findElement(By.id("password")).sendKeys("test");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String error = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage, error);
        driver.quit();
    }


}
