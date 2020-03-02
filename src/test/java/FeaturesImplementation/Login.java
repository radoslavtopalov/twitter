package FeaturesImplementation;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class Login {
    @When("Login with Username: {string} and Password: {string}")
    public void login_with_Username_and_Password(String username, String password) {
        BrowserSetup.driver.findElement(By.xpath("//main[@role=\"main\"]//input[@name=\"session[username_or_email]\"]")).sendKeys(username);
        BrowserSetup.driver.findElement(By.xpath("//main[@role=\"main\"]//input[@name=\"session[password]\"]")).sendKeys(password);
        BrowserSetup.driver.findElement(By.xpath("//main[@role=\"main\"]//div[@data-testid=\"LoginForm_Login_Button\"]")).click();
        //BrowserSetup.driver.navigate().refresh();
    }
}
