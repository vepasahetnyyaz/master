package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElarLogisticsAddCompanyPage {

    public ElarLogisticsAddCompanyPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_company_name")
    public WebElement name;

    @FindBy(id = "id_company_type")
    public WebElement companyTypeDropDown;

    @FindBy(id = "id_status")
    public WebElement statusDropDown;

    @FindBy(id = "id_mc_number")
    public WebElement mcNumber;

    @FindBy(id = "id_dot_number")
    public WebElement dotNumber;

    @FindBy(id = "id_ifta")
    public WebElement ifta;

    @FindBy(xpath = "/html/body/div/div/main/div/div/div[3]/form/div[1]/div/div[3]/div[1]/p[1]/span/span/span[1]/input[1]")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='ext']")
    public WebElement ext;

    @FindBy(xpath = "//input[@class='input-form border disabled-receiver disabled-case first-letter']")
    public WebElement contactName;

    @FindBy(xpath = "/html/body/div/div/main/div/div/div[3]/form/div[1]/div/div[3]/div[2]/p/span/span/span[1]/input")
    public WebElement fax;

    @FindBy(id = "id_address")
    public WebElement street;

    @FindBy(id = "id_apt_suite_company_co")
    public WebElement aptSuite;

    @FindBy(id = "id_city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement stateDropDown;

    @FindBy(id = "id_zip_code")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@class='input-form disabled-not-ext border disabled-company lowercase']")
    public WebElement email;
}
