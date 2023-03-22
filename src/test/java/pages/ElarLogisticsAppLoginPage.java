package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticsAppLoginPage {

    public ElarLogisticsAppLoginPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/main/div/form/p[1]/input")
    public WebElement username;

    @FindBy(id = "id_input_pass")
    public WebElement password;

    @FindBy(xpath = "/html/body/div/div/main/div/form/p[3]/button")
    public WebElement loginBtn;

    @FindBy(xpath = "/html/body/div/div/main/div/form/span/label")
    public WebElement rememberMe;

    @FindBy(xpath = "/html/body/div/div/main/div/form/p[1]/input")
    public WebElement logoutPlaceholder;

    @FindBy(xpath = "/html/body/div/div/main/div/form/label")
    public WebElement expectedErrorMessage;

}
