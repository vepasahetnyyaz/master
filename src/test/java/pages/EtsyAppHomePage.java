package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppHomePage {

    public EtsyAppHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy(xpath = "//a[@class='wt-display-table wt-width-full wt-text-link-no-underline']")
    public WebElement homeFavCategory;

    @FindBy(id="catnav-primary-link-10855")
    public WebElement jewelryCategory;

    @FindBy(id="catnav-primary-link-10923")
    public WebElement clothingAndShoesCategory;

    @FindBy(id="catnav-primary-link-891")
    public WebElement homeAndLivingCategory;




}
