package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginTest {
    WebDriver driver;
    String baseurl = "https://saucedemo.com/";

    @Given("User access the website")
    public void User_access_the_website() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

    }

    @When("User insert Username with the list provided")
    public void user_insert_Username_with_the_list_provided() {
        driver.findElement(By.id("user-name")).sendKeys(main.auth.username);
    }

    @And("User insert password with the list provided")
    public void user_insert_password_with_the_list_provided() {
        driver.findElement(By.id("password")).sendKeys(main.auth.password);
    }

    @Then("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User on Dashboard Page")
    public void user_on_Dashboard_Page(){
        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());
        driver.quit();
    }


    @And("User insert invalid password with the list provided")
    public void user_insert_invalid_password_with_the_list_provided() {
        driver.findElement(By.id("password")).sendKeys("test");
    }

    @Then("User get error message")
    public void user_get_error_message() {
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String error = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage, error);
        driver.quit();
    }
    @Then("User on main Page")
    public void user_on_main_Page() {
        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());
    }

    @When("User click burger menu")
    public void user_Click_Burger_Menu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("User click Logout")
    public void user_Click_Logout() {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        logoutLink.click();
    }

    @Then("User on landing page")
    public void user_On_Landing_Page() {
        driver.quit();
    }

    @And("User on Dashboard Page to doing transaction")
    public void user_On_Dashboard_Page_To_Doing_Transaction() {
        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());

    }
    @And("User Add Product to cart")
    public void user_Add_Product_To_Cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("User click to cart")
    public void user_Click_To_Cart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("User click Checkout Button")
    public void user_Click_Checkout_Button() {
        WebElement titleYourCart = driver.findElement(By.className("title"));
        Assert.assertEquals("Your Cart", titleYourCart.getText());
        pause(1000);
        driver.findElement(By.id("checkout")).click();

    }

    @When("User insert Firstname")
    public void user_Insert_First_name() {
        driver.findElement(By.id("first-name")).sendKeys(main.auth.name);
        pause(1000);
    }

    @And("User insert Lastname")
    public void user_Insert_Last_name() {
        driver.findElement(By.id("last-name")).sendKeys(main.auth.lastname);
        pause(1000);
    }

    @And("User insert Postalcode")
    public void user_Insert_Postalcode() {
        driver.findElement(By.id("postal-code")).sendKeys(main.auth.postalCode);
        pause(1000);
    }

    @Then("User click Continue Button")
    public void user_click_Continue_Button() {
        driver.findElement(By.id("continue")).click();
    }

    @And("User directed to Overview Page")
    public void user_Directed_To_Overview_Page() {
        WebElement titleOverview = driver.findElement(By.className("title"));
        Assert.assertEquals("Checkout: Overview", titleOverview.getText());
    }

    @Then("User click Continue Finish")
    public void user_Click_Continue_Finish() {
        driver.findElement(By.id("finish")).click();
    }

    @And("User directed to Checkout Page")
    public void user_Directed_To_Checkout_Page() {
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

