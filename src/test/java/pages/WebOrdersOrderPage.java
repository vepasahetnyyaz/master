package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebOrdersOrderPage {

    public WebOrdersOrderPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement calculate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtUnitPrice")
    public WebElement pricePerUnitBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtDiscount")
    public WebElement discountBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtTotal")
    public WebElement totalBox;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement city;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visa;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement master;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpress;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNo;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processBtn;

    @FindBy(xpath = "//strong")
    public WebElement successMessage;


}
