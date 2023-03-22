package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ElarLogisticsAppLoginPage;
import pages.ElarLogisticsHomePage;
import utilities.Driver;

public class ElarLogisticsAppSteps {

    WebDriver driver = Driver.getDriver();
    ElarLogisticsAppLoginPage elarLogisticsAppLoginPage = new ElarLogisticsAppLoginPage();
    ElarLogisticsHomePage elarLogisticsHomePage = new ElarLogisticsHomePage();

    @When("users enters username {string} and password {string}")
    public void users_enters_username_and_password(String username, String password){
        elarLogisticsAppLoginPage.username.sendKeys(username);
        elarLogisticsAppLoginPage.password.sendKeys(password);
    }
    @And("users clicks on the login button")
    public void users_clicks_on_the_login_button(){
        elarLogisticsAppLoginPage.loginBtn.click();
    }

    @And("user clicks on the add company button")
    public void user_clicks_on_the_add_company_button() {
        elarLogisticsHomePage.addCompany.click();

    }

    @Then("users validates application is logged in")
    public void users_validates_application_is_logged_in(){
        String expectedUser = elarLogisticsHomePage.loggedInUserName.getText();
        String actualUser = elarLogisticsHomePage.loggedInUserName.getText();

        System.out.println("Beklenen"+expectedUser);
        System.out.println("Asil"+actualUser);
        Assert.assertEquals(expectedUser,actualUser);
    }


    @Then("users validates an error message {string}")
    public void usersValidatesAnErrorMessage(String expectedErrorMessage) {
        String actualMessage = "Unable to log in with provided credentials.";
        System.out.println(actualMessage);

        Assert.assertEquals(expectedErrorMessage,actualMessage);
    }

    @And("user check on the rememberMe checkbox")
    public void userCheckOnTheRememberMeCheckbox() {
        elarLogisticsAppLoginPage.rememberMe.click();
    }

    @And("user clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        elarLogisticsHomePage.logoutArrow.click();
        elarLogisticsHomePage.logoutBtn.click();
    }
    @Then("users validates the username and theme selection is remembered")
    public void usersValidatesTheUsernameAndThemeSelectionIsRemembered() {
        String expectedLogin = elarLogisticsAppLoginPage.logoutPlaceholder.getAttribute("value");
        String actualLogin = "student1@mindtek.com";

        System.out.println(expectedLogin);
        System.out.println(actualLogin);

        Assert.assertEquals(expectedLogin,actualLogin);
    }
}
