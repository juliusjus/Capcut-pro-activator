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

import static org.junit.Assert.assertTrue;

public class LoginPage {
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

    @When("User input (.*) username$")
    public void userInputUsernameAsUsername(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }


    @And("User input (.*) password$")
    public void userInputPasswordAsPassword(String password){
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("User click on login")
    public void userClickOnLogin() {

        driver.findElement(By.id("login-button")).click();

    }

    @Then("User verify (.*) result$")
    public void userVerifyStatusResult(String status){
        if (status.equals("success")){
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
            String title = driver.findElement(By.className("title")).getAttribute("Products");
            Assert.assertEquals(title,"Swag Labs");
        } else {
            String errorMessage = String.valueOf(driver.findElement(By.className("error-button")));
            Assert.assertEquals(errorMessage,"Kredential salah");
        }

    }

}

