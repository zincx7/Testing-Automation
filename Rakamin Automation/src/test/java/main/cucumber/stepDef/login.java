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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
    public void userOnDashboardPage(){
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
    @Then("User on main Page")
    public void userOnMainPage() {
        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());
    }

    @When("User click burger menu")
    public void userClickBurgerMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click Logout")
    public void userClickLogout() {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }

    @Then("User on landing page")
    public void userOnLandingPage() {
        driver.quit();
    }

    @And("User on Dashboard Page to doing transaction")
    public void userOnDashboardPageToDoingTransaction() {
        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());

    }
    @And("User Add Product to cart")
    public void userAddProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click to cart")
    public void userClickToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("User click Checkout Button")
    public void userClickCheckoutButton() {
        WebElement titleYourCart = driver.findElement(By.className("title"));
        Assert.assertEquals("Your Cart", titleYourCart.getText());
        pause(1000);
        driver.findElement(By.id("checkout")).click();

    }

    @When("User insert Firstname")
    public void userInsertFirstname() {
        driver.findElement(By.id("first-name")).sendKeys(auth.name);
        pause(1000);
    }

    @And("User insert Lastname")
    public void userInsertLastname() {
        driver.findElement(By.id("last-name")).sendKeys(auth.lastname);
        pause(1000);
    }

    @And("User insert Postalcode")
    public void userInsertPostalcode() {
        driver.findElement(By.id("postal-code")).sendKeys(auth.postalCode);
        pause(1000);
    }

    @Then("User click Continue Button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @And("User directed to Overview Page")
    public void userDirectedToOverviewPage() {
        WebElement titleOverview = driver.findElement(By.className("title"));
        Assert.assertEquals("Checkout: Overview", titleOverview.getText());
    }

    @Then("User click Continue Finish")
    public void userClickContinueFinish() {
        driver.findElement(By.id("finish")).click();
    }

    @And("User directed to Checkout Page")
    public void userDirectedToCheckoutPage() {
        WebElement titleCompleteHeader = driver.findElement(By.className("complete-header"));
        Assert.assertEquals("Thank you for your order!", titleCompleteHeader.getText());
        driver.quit();
    }

    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }



}

