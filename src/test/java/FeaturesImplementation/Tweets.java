package FeaturesImplementation;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Tweets {

    @When("Post new Tweet with text {string}")
    public void post_new_Tweet(String textTweet) {
        WebElement newTweetField = BrowserSetup.driver.findElement(By.xpath("//div[@aria-label='Tweet text']"));
        newTweetField.click();
        newTweetField.sendKeys(textTweet);

        WebElement tweetingButton = BrowserSetup.driver.findElement(By.xpath("//div[@data-testid=\"tweetButtonInline\"]"));
        tweetingButton.click();
    }

    @When("Delete tweet")
    public void delete_tweet() {
        WebElement moreButton = BrowserSetup.driver.findElement(By.xpath("//article//div[@aria-label=\"More\"]"));
        moreButton.click();

        WebElement deleteButton = BrowserSetup.driver.findElement(By.xpath("//div[@role=\"menuitem\"][1]"));
        deleteButton.click();

        WebElement deleteConfirmationButton = BrowserSetup.driver.findElement(By.xpath("//div[@data-testid=\"confirmationSheetConfirm\"]"));
        deleteConfirmationButton.click();
    }

    @Then("Tweet is deleted")
    public void tweet_is_deleted(){
        try {
            boolean isTweetPresent = BrowserSetup.driver.findElement(By.xpath("//article")).isDisplayed();
            Assert.assertFalse(isTweetPresent, "Tweet is not deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Verify Tweet is deleted with {string} alert message")
    public void verify_Tweet_is_deleted_with_alert_message(String alertMessageExpected) {
        WebElement deletedTweetAlert = BrowserSetup.driver.findElement(By.xpath("//div[@role=\"alert\"]//span[text()='Your Tweet was deleted']"));
        String alertMessageActual = deletedTweetAlert.getText();
        Assert.assertEquals(alertMessageActual, alertMessageExpected);
    }

}
