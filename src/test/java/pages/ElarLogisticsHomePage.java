package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticsHomePage {

    public ElarLogisticsHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/div/div/header/div[1]/ul/li[5]/a/span[1]/img")
    public WebElement logoutArrow;

    @FindBy(xpath = "/html/body/div/div/header/div[1]/ul/li[5]/ul/li/a/span/span")
    public WebElement logoutBtn;

    @FindBy(xpath = "/html/body/div/div/header/div[1]/ul/li[5]/a/p")
    public WebElement loggedInUserName;

    @FindBy(xpath = "//a[@class='link-btm-menu']")
    public WebElement addCompany;

}
