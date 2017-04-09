package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class Stepdefs {

    WebDriver driver;
    String baseUrl = "http://localhost:4567";

    @Before
    public void setUp() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "\"D:\\User\\Tiedostot\\GitHub\\OhTu\\Viikko4\\WebLogin\\chromedriver.exe\"");
    }

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @Given("^new user is selected$")
    public void user_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" is entered$")
    public void new_user_credentials_are_given(String username, String password) throws Throwable {
        createUser(username, password);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^nonexistent username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void nonexistent_username_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("^user is not created and error \"password can not contain only letters\" is reported$")
    public void user_is_not_created_and_error_is_reported() throws Throwable {
        pageHasContent("password can not contain only letters");
    }

    @Then("^user is not created and error \"username is already taken\" is reported$")
    public void not_created_existing() throws Throwable {
        pageHasContent("username is already taken");
    }

    @Then("^user is not created and error \"password should have at least 8 characters\" is reported$")
    public void not_created_password() throws Throwable {
        pageHasContent("password should have at least 8 characters");
    }

    @Then("^user is not created and error \"username should have at least 3 characters\" is reported$")
    public void not_created() throws Throwable {
        pageHasContent("username should have at least 3 characters");
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" is entered")
    public void username_and_password_are_entered(String username, String password) throws Throwable {
        createUser(username, password);
    }

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" and incorrect confirmation \"([^\"]*)\" is entered")
    public void username_and_password_are_entered_but_confirmation_wrong(String arg1, String arg2,
            String arg3) throws Throwable {
        createUserPConf(arg1, arg2, arg3);
    }

    @Then("^user is not created and error \"password and password confirmation do not match\" is given")
    public void user_is_not_created_password_confirmation() throws Throwable {
        pageHasContent("password and password confirmation do not match");
    }

    @Then("^new user is created$")
    public void user_is_created() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is successfully created$")
    public void user_created(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        createUser(username, password);
    }

    @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is unsuccessfully created$")
    public void user_not_created(String username, String password) throws Throwable {
        user_created(username, password);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void createUser(String username, String password) {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }

    private void createUserPConf(String username, String password, String passwordConf) {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConf);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
