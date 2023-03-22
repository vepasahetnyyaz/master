package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Map;

public class WebOrdersSteps {

    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();


    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        System.out.println(username); // username="Tester"
        System.out.println(password); // password="test"

        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);


    }

    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        webOrdersLoginPage.loginBtn.click();

    }

    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {
        String expectedTitle = "Web Orders";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

    }


    @Then("user validates an error message {string}")
    public void userValidatesAnErrorMessage(String expectedErrorMessage) {
        String actualMessage = webOrdersLoginPage.errorMessage.getText();
        System.out.println(actualMessage);

        Assert.assertEquals(expectedErrorMessage, actualMessage);
    }

    @When("user clicks on the Order module")
    public void user_clicks_on_the_order_module() {
        webOrdersHomePage.orderModule.click();

    }

    @When("user selects {string} with {int} and clicks on calculate button")
    public void user_selects_with_quantity_and_clicks_on_calculate_button(String product, int quantity) {
        BrowserUtils.selectValueByDropdown(webOrdersOrderPage.productDropdown, product); // product = "MyMoney";
        webOrdersOrderPage.quantityBox.clear();
        webOrdersOrderPage.quantityBox.sendKeys(quantity + "");
        webOrdersOrderPage.calculate.click();

    }

    @Then("user validates total is calculated properly for {int}")
    public void user_validates_total_is_calculated_properly_for_quantity(int quantity) {
        int expectedTotal = 0;

        // storing my values for calculation as String
        String pricePerUnit = webOrdersOrderPage.pricePerUnitBox.getAttribute("value"); // text
        String discountAmount = webOrdersOrderPage.discountBox.getAttribute("value"); // 8%

        // converting my String values for calculation to int
        int pricePerUnitInt = Integer.parseInt(pricePerUnit);
        int discountAmountInt = Integer.parseInt(discountAmount); // int = 8

        if (discountAmountInt == 0) {
            expectedTotal = quantity * pricePerUnitInt;
        } else {
            expectedTotal = quantity * pricePerUnitInt; // 10 * 100 = 1000;
            expectedTotal = expectedTotal - expectedTotal * discountAmountInt / 100;  // 1000 - 80 = 920;
        }

        String actualTotal = webOrdersOrderPage.totalBox.getAttribute("value");
        int actualTotalInt = Integer.parseInt(actualTotal);

        Assert.assertEquals(expectedTotal, actualTotalInt);

    }

    @When("user creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>.

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        System.out.println("Datatable as map: " + data);
        BrowserUtils.selectValueByDropdown(webOrdersOrderPage.productDropdown, data.get("product")); // returns "MyMoney" from dataTable, converted to data;
        webOrdersOrderPage.quantityBox.sendKeys(data.get("quantity"));
        webOrdersOrderPage.customerName.sendKeys(data.get("name"));
        webOrdersOrderPage.street.sendKeys(data.get("street"));
        webOrdersOrderPage.city.sendKeys(data.get("city"));
        webOrdersOrderPage.state.sendKeys(data.get("state"));
        webOrdersOrderPage.zip.sendKeys(data.get("zip"));

        if (data.get("cType").equals("Visa")) {
            webOrdersOrderPage.visa.click();
        } else if (data.get("cType").equals("Master")) {
            webOrdersOrderPage.master.click();
        } else if (data.get("cType").equals("American")) {
            webOrdersOrderPage.americanExpress.click();
        } else {
            System.out.println("There is no such card available. Please provide valid card type.");
        }

        webOrdersOrderPage.cardNo.sendKeys(data.get("cc"));
        webOrdersOrderPage.expireDate.sendKeys(data.get("exp"));
        webOrdersOrderPage.processBtn.click();

    }

    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
        String actualMessage = webOrdersOrderPage.successMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);


    }

}
