package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class BrowserUtils {

    /**
     * This method generates emails with random username.
     * Ex:
     *      .getRandomEmail() -> returns: user1234frw42356gsd@gmail.com
     */

    public static String getRandomEmail(){
        UUID uuid = UUID.randomUUID();
        return "username"+uuid+"@gmail.com";
    }

    /**
     * This method generates very strong password
     * Ex:
     *      getRandomStrongPassword(); -> returns random very strong password
     */

    public static String getRandomStrongPassword(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForTextToBePresentInElement(WebDriver driver, By locator, String text, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static boolean waitForTitleToContain(WebDriver driver, String title, long timeout) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.titleContains(title));
    }

//    /**
//     * This method accepts WebElement of dropdown and String value of dropdown,
//     * and will select provided value in dropdown.
//     * Ex:
//     *      .selectDropdownByValue() -> it will select an option by value.
//     */
//
//    public static void selectDropdownByValue(WebElement dropdown, String value){
//        Select select = new Select(dropdown);
//        select.selectByValue(value);
//    }
    /**
     * This method will accept WebElement of dropdown
     * and String value of dropdown, and will select
     * provided value in dropdown.
     */
    public static void selectValueByDropdown(WebElement element, Object value){
        Select select = new Select(element);
        select.selectByValue(value.toString());
    }

    public static void selectDropdownByVisibleText(WebElement dropdown, String visibleText){
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }



    /**
     * This method takes screenshots.
     * Ex:
     *      .takeScreenshot("verifyLoginScreenshot")
     */

    public static void takeScreenshot(String testName) throws IOException {
        WebDriver driver = Driver.getDriver();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/"+testName+".png";
        File file = new File(path);
        FileUtils.copyFile(screenshot, file);
    }
}
