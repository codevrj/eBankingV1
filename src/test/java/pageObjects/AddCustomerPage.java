package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver driver;

    // Another way to find elements

//    @FindBy(how = How.NAME , using = "name")
//    @CacheLookup
//    WebElement name;
//
//    public AddCustomerPage(WebDriver driver){
//        driver1 = driver;
//        PageFactory.initElements(driver1,this);
//    }

    By addCustomer = By.linkText("New Customer");
    By cusName = By.name("name");
    By genderM = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]");
    By genderF = By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]");
    By dob = By.name("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By telephone = By.name("telephoneno");
    By email = By.name("emailid");
    By password = By.name("password");
    By submit = By.name("Submit");

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddCustomer() {
        driver.findElement(addCustomer).click();
    }
    public void setCusName(String name) {
        driver.findElement(cusName).sendKeys(name);
    }
    public void setGenderM() {
        driver.findElement(genderM).click();
    }
    public void setGenderF() {
        driver.findElement(genderF).click();
    }
    public void setDob(String mm, String dd, String yy) {
        driver.findElement(dob).sendKeys(mm);
        driver.findElement(dob).sendKeys(dd);
        driver.findElement(dob).sendKeys(yy);
    }
    public void setAddress(String adrs) {
        driver.findElement(address).sendKeys(adrs);
    }
    public void setCity(String cty) {
        driver.findElement(city).sendKeys(cty);
    }
    public void setState(String stat) {
        driver.findElement(state).sendKeys(stat);
    }
    public void setPin(String pinno) {
        driver.findElement(pin).sendKeys(pinno);
    }

//    public void setPin(int pinno) {                 // This can use when provide int values as input....
//        driver.findElement(pin).sendKeys(String.valueOf(pinno));
//    }

    public void setTelephone(String tel) {
        driver.findElement(telephone).sendKeys(tel);
    }
    public void setEmail(String em) {
        driver.findElement(email).sendKeys(em);
    }
    public void setPassword(String pw) {
        driver.findElement(password).sendKeys(pw);
    }
    public void clickSubmit() {
        driver.findElement(submit).click();
    }
}
