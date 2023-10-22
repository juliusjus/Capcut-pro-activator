package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoChart {
    WebDriver driver;
    @Given("User Open browser")
    public void userOpenBrowser() {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("User Open Website Saucedemo")
    public void userOpenWebsiteSaucedemo() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @When("User input valid username")
    public void userInputValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }


    @And("User input valid password")
    public void userInputValidPassword(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click on login")
    public void userClickOnLogin() {

        driver.findElement(By.id("login-button")).click();

    }
    @And("User in product page")
    public void userInProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
        String title = driver.findElement(By.className("title")).getAttribute("Products");
    }

    @When("User click add to cart")
    public void userClickAddToChart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    @Then("The cart is added")
    public void theCartIsAdded(){
        driver.findElement(By.className("shopping_cart_badge")).getAttribute("4");
    }
}
