package FeaturesImplementation;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class Login {
    @When("Login with Username: {string} and Password: {string}")
    public void login_with_Username_and_Password(String username, String password) {
        BrowserSetup.driver.findElement(By.xpath("//input[@placeholder='Phone, email or username']")).sendKeys(username);
        BrowserSetup.driver.findElement(By.xpath("//input[@class='js-password-field']")).sendKeys(password);
        BrowserSetup.driver.findElement(By.xpath("//button[@type='submit']")).click();
        //BrowserSetup.driver.navigate().refresh();
    }
}
