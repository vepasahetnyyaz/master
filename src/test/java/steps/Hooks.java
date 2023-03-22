package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver driver = Driver.getDriver();

    @Given("user navigates to {string} application")
    public void user_navigates_to_application(String webApp) { // webApp="WebOrders"
        if (webApp.equals("WebOrders")) {
            driver.get(ConfigReader.getProperty("WebOrdersURL"));
        }
        else if (webApp.equals("EtsyApp")) {
            driver.get(ConfigReader.getProperty("EtsyAppURL"));
        }
        else if (webApp.equals("ElarLogisticsApp")){
            driver.get(ConfigReader.getProperty("ElarLogisticsAppURL"));
        }
        else if (webApp.equals("MindtekPizzaApp")){
            driver.get(ConfigReader.getProperty("MindtekPizzaAppURL"));
        }
    }

    @Before
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        System.out.println("Method runs before scenario");
    }


    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","myFailure");
        }
        driver.quit();
        System.out.println("Method runs after scenario");

    }

}
