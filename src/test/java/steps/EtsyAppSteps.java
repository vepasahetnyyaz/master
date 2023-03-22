package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;
import java.util.Locale;

public class EtsyAppSteps {

    WebDriver driver = Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage = new EtsyAppHomePage();
    EtsyAppSearchPage etsyAppSearchPage = new EtsyAppSearchPage();

    @When("user searches for {string}")
    public void user_searches_for(String item) { //item="sofa"
        etsyAppHomePage.searchBox.sendKeys(item);
        etsyAppHomePage.searchBox.sendKeys(Keys.ENTER);

    }


    @Then("user validates search result items name contains keyword {string}")
    public void user_validates_search_result_items_name_contains_keyword(String item) {//item="sofa"
        List<WebElement> listOfNames = etsyAppSearchPage.itemNamesList;

        for (WebElement element : listOfNames) {
            System.out.println(element.getText());
            Assert.assertTrue(element.getText() + " doesn't contain " + item,
                    element.getText().toLowerCase(Locale.ROOT).contains(item) ||
                            element.getText().toLowerCase(Locale.ROOT).contains("couch") ||
                            element.getText().toLowerCase(Locale.ROOT).contains("seating") ||
                            element.getText().toLowerCase(Locale.ROOT).contains("kilm"));
        }

    }


    @And("user applies price filter {int}")
    public void userAppliesPriceFilter(int price) {
        etsyAppSearchPage.allFiltersBtn.click();
        etsyAppSearchPage.over1500Radio.click();
        etsyAppSearchPage.applyBtn.click();

    }

    @Then("user validates that item prices are over {int}")
    public void userValidatesThatItemPricesAre(int price) throws InterruptedException {
        Thread.sleep(3000);
        // will wait for element to be visible
        BrowserUtils.waitForElementToBeVisible(driver, By.xpath("//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//span[@class='currency-value']"), 5);
        // will get the list of Webelement
        List<WebElement> listOfPrices = etsyAppSearchPage.listOfPrices;

        for (WebElement element : listOfPrices) {
//            System.out.println(element.getText());
            // String = "3,999.00" --> double = 3999.00
            String strPrice = element.getText().replaceAll(",", ""); // "3,999.00" --> 3999.00
            double actualPriceDouble = Double.parseDouble(strPrice); // String "3999.00" --> Double 3999.00\
            System.out.println(actualPriceDouble);

            Assert.assertTrue(actualPriceDouble >= price); // 3999.00 >= 1500


        }
    }

    @When("user clicks on specific {string} category")
    public void user_clicks_on_specific_category(String category) {
        if (category.equals("Home Favorites")) {
            etsyAppHomePage.homeFavCategory.click();
        }else if (category.equals("Jewelry & Accessories")){
            etsyAppHomePage.jewelryCategory.click();
        }else if (category.equals("Clothing & Shoes")){
            etsyAppHomePage.clothingAndShoesCategory.click();
        }else if (category.equals("Home & Living")){
            etsyAppHomePage.homeAndLivingCategory.click();
        }
    }

    @Then("user validates the title is {string}")
    public void user_validates_the_title_is(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


    }


}
